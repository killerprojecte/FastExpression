package dev.rgbmc.expression.parameters;

import dev.rgbmc.expression.functions.FunctionParameter;

public class BooleanParameter extends FunctionParameter {
    public BooleanParameter(boolean bool) {
        setObject(bool);
    }

    public boolean getBoolean() {
        return (boolean) getObject();
    }

    public void setBoolean(boolean bool) {
        setObject(bool);
    }
}
