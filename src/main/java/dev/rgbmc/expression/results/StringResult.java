package dev.rgbmc.expression.results;

import dev.rgbmc.expression.functions.FunctionResult;

public class StringResult extends FunctionResult {
    private final String string;
    public StringResult(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
