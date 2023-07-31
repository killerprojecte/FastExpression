package dev.rgbmc.expression.parameters;

import dev.rgbmc.expression.functions.FunctionParameter;

public class IntegerParameter extends FunctionParameter {
    public IntegerParameter(int integer) {
        setObject(integer);
    }

    public int getInteger() {
        return (int) getObject();
    }

    public void setInteger(int integer) {
        setObject(integer);
    }
}
