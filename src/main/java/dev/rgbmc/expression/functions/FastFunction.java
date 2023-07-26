package dev.rgbmc.expression.functions;

public interface FastFunction {
    FunctionResult call(String parameter);

    String getName();
}
