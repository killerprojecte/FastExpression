package dev.rgbmc.expression.results;

import dev.rgbmc.expression.functions.FunctionResult;

public class BooleanResult extends FunctionResult {
    private final boolean bool;
    public BooleanResult(boolean bool) {
        this.bool = bool;
    }

    public boolean getBoolean() {
        return bool;
    }
}
