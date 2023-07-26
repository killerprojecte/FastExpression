package dev.rgbmc.expression.test;

import dev.rgbmc.expression.functions.FastFunction;
import dev.rgbmc.expression.functions.FunctionResult;

public class TestFunction implements FastFunction {
    @Override
    public FunctionResult call(String parameter) {
        System.out.println("Hello, " + parameter + "!");
        return FunctionResult.SUCCESS;
    }

    @Override
    public String getName() {
        return "test";
    }
}
