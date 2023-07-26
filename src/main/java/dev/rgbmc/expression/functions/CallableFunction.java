package dev.rgbmc.expression.functions;

public class CallableFunction {
    private final FastFunction function;
    private final String parameter;
    public CallableFunction(FastFunction function, String parameter) {
        this.function = function;
        this.parameter = parameter;
    }

    public FastFunction getFunction() {
        return function;
    }

    public String getParameter() {
        return parameter;
    }

    public FunctionResult callFunction() {
        return function.call(parameter);
    }
}
