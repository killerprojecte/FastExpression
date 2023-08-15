package dev.rgbmc.expression.results;

import dev.rgbmc.expression.functions.FunctionResult;

public class DoubleResult extends FunctionResult {
    private final double value;
    public DoubleResult(double value) {
        this.value = value;
    }

    public double getDouble() {
        return value;
    }
}
