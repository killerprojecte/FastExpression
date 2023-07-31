package dev.rgbmc.expression.test;

import dev.rgbmc.expression.functions.FastFunction;
import dev.rgbmc.expression.functions.FunctionParameter;
import dev.rgbmc.expression.functions.FunctionResult;
import dev.rgbmc.expression.parameters.StringParameter;

public class CompareFunction implements FastFunction {
    @Override
    public FunctionResult call(FunctionParameter functionParameter) {
        String parameter = ((StringParameter) functionParameter).getString();
        if (parameter.contains(">")) {
            if (parameter.contains(">=")) {
                parameter = parameter
                        .replace(" >=", ">=")
                        .replace(">= ", ">=")
                        .replace(" >= ", ">=");
                String[] split = parameter.split(">=");
                boolean status = true;
                for (int i = 0; i < split.length; i++) {
                    if (split.length-1 == i) break;
                    if (!status) break;
                    double point = Double.parseDouble(split[0]);
                    double point2 = Double.parseDouble(split[1]);
                    status = point >= point2;
                }
                if (status) {
                    return new FunctionResult.DefaultResult(FunctionResult.Status.SUCCESS);
                } else {
                    return new FunctionResult.DefaultResult(FunctionResult.Status.FAILURE);
                }
            } else {
                parameter = parameter
                        .replace(" >", ">")
                        .replace("> ", ">")
                        .replace(" > ", ">");
                String[] split = parameter.split(">");
                boolean status = true;
                for (int i = 0; i < split.length; i++) {
                    if (split.length-1 == i) break;
                    if (!status) break;
                    double point = Double.parseDouble(split[0]);
                    double point2 = Double.parseDouble(split[1]);
                    status = point > point2;
                }
                if (status) {
                    return new FunctionResult.DefaultResult(FunctionResult.Status.SUCCESS);
                } else {
                    return new FunctionResult.DefaultResult(FunctionResult.Status.FAILURE);
                }
            }
        } else if (parameter.contains("<")) {
            if (parameter.contains("<=")) {
                parameter = parameter
                        .replace(" <=", "<=")
                        .replace("<= ", "<=")
                        .replace(" <= ", "<=");
                String[] split = parameter.split("<=");
                boolean status = true;
                for (int i = 0; i < split.length; i++) {
                    if (split.length-1 == i) break;
                    if (!status) break;
                    double point = Double.parseDouble(split[0]);
                    double point2 = Double.parseDouble(split[1]);
                    status = point <= point2;
                }
                if (status) {
                    return new FunctionResult.DefaultResult(FunctionResult.Status.SUCCESS);
                } else {
                    return new FunctionResult.DefaultResult(FunctionResult.Status.FAILURE);
                }
            } else {
                parameter = parameter
                        .replace(" <", "<")
                        .replace("< ", "<")
                        .replace(" < ", "<");
                String[] split = parameter.split("<");
                boolean status = true;
                for (int i = 0; i < split.length; i++) {
                    if (split.length-1 == i) break;
                    if (!status) break;
                    double point = Double.parseDouble(split[0]);
                    double point2 = Double.parseDouble(split[1]);
                    status = point < point2;
                }
                if (status) {
                    return new FunctionResult.DefaultResult(FunctionResult.Status.SUCCESS);
                } else {
                    return new FunctionResult.DefaultResult(FunctionResult.Status.FAILURE);
                }
            }
        } else if (parameter.contains("==")) {
            parameter = parameter
                    .replace(" ==", "==")
                    .replace("== ", "==")
                    .replace(" == ", "==");
            String[] split = parameter.split("==");
            boolean status = true;
            for (int i = 0; i < split.length; i++) {
                if (split.length-1 == i) break;
                if (!status) break;
                status = split[0].equals(split[1]);
            }
            if (status) {
                return new FunctionResult.DefaultResult(FunctionResult.Status.SUCCESS);
            } else {
                return new FunctionResult.DefaultResult(FunctionResult.Status.FAILURE);
            }
        }
        return new FunctionResult.DefaultResult(FunctionResult.Status.ERROR);
    }

    @Override
    public String getName() {
        return "compare";
    }
}
