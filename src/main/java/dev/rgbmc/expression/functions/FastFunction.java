package dev.rgbmc.expression.functions;

public interface FastFunction {
    FunctionResult call(FunctionParameter parameter);

    String getName();
}
