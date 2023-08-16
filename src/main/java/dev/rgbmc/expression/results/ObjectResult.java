package dev.rgbmc.expression.results;

import dev.rgbmc.expression.functions.FunctionResult;

public class ObjectResult extends FunctionResult {
    private final Object object;
    public ObjectResult(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
