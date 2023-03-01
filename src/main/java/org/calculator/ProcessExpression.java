package org.calculator;

public class ProcessExpression {

    private int opIndex;
    private Character operation = null;
    private final StringBuilder PART_A = new StringBuilder();
    private final StringBuilder PART_B = new StringBuilder();
    private final String EXPRESSION;

    public ProcessExpression(String expr) {
        this.EXPRESSION = expr;
    }

    public int getResult() {
        if (expressionIsValid()) {
            checkOperation();
            separate();
            int convertedA = Converter.romanToInteger(PART_A.toString());
            int convertedB = Converter.romanToInteger(PART_B.toString());
            switch (operation) {
                case '+' -> {
                    return convertedA + convertedB;
                }
                case '-' -> {
                    return convertedA - convertedB;
                }
                case '*' -> {
                    return convertedA * convertedB;
                }
                case '/' -> {
                    return convertedA / convertedB;
                }
            }
        } else System.err.println("INVALID EXPRESSION");
        return 0;
    }

    private boolean expressionIsValid() {
        boolean lengthValid = EXPRESSION.length() > 2;
        boolean containOperation = false;
        for (char ch : EXPRESSION.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                containOperation = true;
                break;
            }
        }
        return lengthValid && containOperation;
    }

    private void checkOperation() {
        for (char ch : EXPRESSION.toCharArray()) {
            if (ch == '+') {
                setOperation('+');
                opIndex = EXPRESSION.indexOf(ch);
                break;
            }
            if (ch == '-') {
                setOperation('-');
                opIndex = EXPRESSION.indexOf(ch);
                break;
            }
            if (ch == '*') {
                setOperation('*');
                opIndex = EXPRESSION.indexOf(ch);
                break;
            }
            if (ch == '/') {
                setOperation('/');
                opIndex = EXPRESSION.indexOf(ch);
                break;
            }
        }
    }

    public void separate() {
//        int lastIndex = 0;
//        partA.append(expr.charAt(lastIndex));
        PART_A.append(EXPRESSION, 0, opIndex);
        PART_B.append(EXPRESSION, opIndex + 1, EXPRESSION.length());
    }

    private void setOperation(Character operation) {
        this.operation = operation;
    }

    public String getExpr() {
        return EXPRESSION;
    }
}

