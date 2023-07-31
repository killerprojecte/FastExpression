package dev.rgbmc.expression.functions;

public class CallableFunction {
    private final FastFunction function;
    private final FunctionParameter parameter;

    public CallableFunction(FastFunction function, FunctionParameter parameter) {
        this.function = function;
        this.parameter = parameter;
    }

    public FastFunction getFunction() {
        return function;
    }

    public FunctionParameter getParameter() {
        return parameter;
    }

    public FunctionResult callFunction() {
        return function.call(parameter);
    }
}
