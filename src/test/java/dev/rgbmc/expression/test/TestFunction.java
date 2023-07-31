package dev.rgbmc.expression.test;

import dev.rgbmc.expression.functions.FastFunction;
import dev.rgbmc.expression.functions.FunctionParameter;
import dev.rgbmc.expression.functions.FunctionResult;
import dev.rgbmc.expression.parameters.StringParameter;

public class TestFunction implements FastFunction {
    @Override
    public FunctionResult call(FunctionParameter parameter) {
        StringParameter stringParameter = (StringParameter) parameter;
        System.out.println("Hello, " + stringParameter.getString() + "!");
        return new FunctionResult.DefaultResult(FunctionResult.Status.SUCCESS);
    }

    @Override
    public String getName() {
        return "test";
    }
}
