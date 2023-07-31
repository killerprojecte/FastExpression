package dev.rgbmc.expression.parameters;

import dev.rgbmc.expression.functions.FunctionParameter;

public class DoubleParameter extends FunctionParameter {
    public DoubleParameter(double value) {
        setObject(value);
    }

    public double getInteger() {
        return (double) getObject();
    }

    public void setInteger(double value) {
        setObject(value);
    }
}
