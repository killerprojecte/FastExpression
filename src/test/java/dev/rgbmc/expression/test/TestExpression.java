package dev.rgbmc.expression.test;

import dev.rgbmc.expression.FastExpression;
import dev.rgbmc.expression.functions.CallableFunction;
import dev.rgbmc.expression.functions.FunctionResult;

public class TestExpression {
    public static void main(String[] args) {
        FastExpression expression = new FastExpression();
        expression.getFunctionManager().register(new TestFunction(), "test1", "t", "测试", "#");
        expression.getFunctionManager().register(new CompareFunction(), "c", "check");
        for (CallableFunction callableFunction : expression.getFunctionManager()
                .parseExpression("test(Just A Test) t(Another Test) 测试(中文测试) compare(Test == Test)")) {
            if (((FunctionResult.DefaultResult) callableFunction.callFunction()).getStatus() != FunctionResult.Status.SUCCESS) {
                System.err.println("Return error value");
                break;
            }
        }
    }
}
