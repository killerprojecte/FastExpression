package dev.rgbmc.expression.results;

import dev.rgbmc.expression.functions.FunctionResult;

public class IntegerResult extends FunctionResult {
    private final int integer;
    public IntegerResult(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }
}
