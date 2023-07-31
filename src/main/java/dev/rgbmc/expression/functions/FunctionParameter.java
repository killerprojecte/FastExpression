package dev.rgbmc.expression.functions;

public abstract class FunctionParameter {
    private Object object;

    protected Object getObject() {
        return object;
    }

    protected void setObject(Object object) {
        this.object = object;
    }
}
