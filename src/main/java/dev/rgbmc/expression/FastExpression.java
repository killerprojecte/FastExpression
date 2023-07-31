package dev.rgbmc.expression;

import dev.rgbmc.expression.managers.AliasesManager;
import dev.rgbmc.expression.managers.FunctionManager;

public class FastExpression {
    private final FunctionManager functionManager;
    private final AliasesManager aliasesManager;

    public FastExpression() {
        functionManager = new FunctionManager(this);
        aliasesManager = new AliasesManager();
    }

    public FunctionManager getFunctionManager() {
        return functionManager;
    }

    public AliasesManager getAliasesManager() {
        return aliasesManager;
    }
}
