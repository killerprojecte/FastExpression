package dev.rgbmc.expression.test;

import dev.rgbmc.expression.FastExpression;
import dev.rgbmc.expression.functions.CallableFunction;
import dev.rgbmc.expression.managers.FunctionManager;

public class ExpressionBenchmark {
    public static void main(String[] args) {
        FastExpression expression = new FastExpression();
        FunctionManager manager = expression.getFunctionManager();
        manager.register(new TestFunction(), "t");
        manager.register(new CompareFunction(), "c");

        // Test 1
        System.out.println("Testing performance with 1 function");
        long startTime = System.currentTimeMillis();
        long endTime;
        for (CallableFunction function : manager.parseExpression("test(Running Test 1)")) {
            function.callFunction();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Test 1 Used Time: " + (endTime - startTime) + "ms");

        // Test 2
        System.out.println("Test performance with 2 function");
        startTime = System.currentTimeMillis();
        for (CallableFunction function : manager.parseExpression("test(Running Test 2) test(Running Test 2 Step 2)")) {
            function.callFunction();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Test 2 Used Time: " + (endTime - startTime) + "ms");

        // Test 3
        System.out.println("Test performance with 1 function and call with alias");
        startTime = System.currentTimeMillis();
        for (CallableFunction function : manager.parseExpression("t(Running Test 3)")) {
            function.callFunction();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Test 3 Used Time: " + (endTime - startTime) + "ms");
    }
}
