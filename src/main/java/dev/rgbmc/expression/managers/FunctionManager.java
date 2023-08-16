package dev.rgbmc.expression.managers;

import dev.rgbmc.expression.FastExpression;
import dev.rgbmc.expression.functions.CallableFunction;
import dev.rgbmc.expression.functions.FastFunction;
import dev.rgbmc.expression.functions.FunctionParameter;
import dev.rgbmc.expression.functions.FunctionResult;
import dev.rgbmc.expression.parameters.StringParameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionManager {
    private final Map<String, FastFunction> functions;
    private final FastExpression instance;

    public FunctionManager(FastExpression instance) {
        functions = new HashMap<>();
        this.instance = instance;
    }

    public FunctionResult call(String registerName, FunctionParameter parameter) {
        return get(registerName).call(parameter);
    }

    public FastFunction get(String registerName) {
        if (functions.containsKey(registerName)) {
            return functions.get(registerName);
        } else {
            String real = instance.getAliasesManager().getRealName(registerName);
            if (real.equals(registerName)) {
                throw new IllegalArgumentException("Function " + registerName + " does not exist");
            }
            return functions.get(real);
        }
    }

    public void register(FastFunction function) {
        String registerName = function.getName();
        if (functions.containsKey(registerName)) {
            throw new IllegalStateException("Function " + registerName + " already exists");
        } else {
            functions.put(registerName, function);
        }
    }

    public void register(FastFunction function, String... aliases) {
        register(function);
        instance.getAliasesManager().registerAliases(function.getName(), aliases);
    }

    private boolean exists(String registerName) {
        return functions.containsKey(registerName);
    }

    public List<CallableFunction> parseExpression(String expression) {
        List<CallableFunction> callableFunctions = new ArrayList<>();
        Pattern pattern = Pattern.compile("([\\w\\p{L}]+)\\(((?:[^()]*|\\((?:[^()]*|\\([^()]*\\))*\\))*)\\)");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            String functionName = matcher.group(1);
            String parameter = matcher.group(2);
            callableFunctions.add(new CallableFunction(get(functionName), new StringParameter(parameter)));
        }
        return callableFunctions;
    }

    public Map<String, FastFunction> getRegistry() {
        return functions;
    }
}
