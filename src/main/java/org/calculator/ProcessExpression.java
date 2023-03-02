package org.calculator;

public class ProcessExpression {

    private final Character operation = checkOperation();
    private final StringBuilder partA = new StringBuilder();
    private final StringBuilder partB = new StringBuilder();
    private final String EXPRESSION;

    public enum Operation {
        ADDITION('+'),
        SUBTRACTION('-'),
        MULTIPLICATION('*'),
        DIVISION('/');

        private final char opSymbol;

        Operation(char ch) {
            this.opSymbol = ch;
        }

        public char getChar() {
            return opSymbol;
        }
    }

    public ProcessExpression(String expr) {
        this.EXPRESSION = expr;
    }

    public int getResult() {
        if (expressionIsValid()) {
            separate();
            int convertedA = Converter.romanToInteger(partA.toString());
            int convertedB = Converter.romanToInteger(partB.toString());
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
        }
        throw new InvalidExpressionException("Invalid expression: " + EXPRESSION);
    }

    private boolean expressionIsValid() {
        boolean lengthValid = EXPRESSION.length() > 2;
        String regex = "^\\s*[IVXLCDM]+\\s*[+\\-*/]\\s*[IVXLCDM]+\\s*$";
        return lengthValid && EXPRESSION.matches(regex);
    }

    private Character checkOperation() {
        for (char ch : EXPRESSION.toCharArray()) {
            if (ch == Operation.ADDITION.getChar()) {
                return ch;
            }
            if (ch == Operation.SUBTRACTION.getChar()) {
                return ch;
            }
            if (ch == Operation.MULTIPLICATION.getChar()) {
                return ch;
            }
            if (ch == Operation.DIVISION.getChar()) {
                return ch;
            }
        }
        throw new InvalidExpressionException("Operation not found in expression: " + EXPRESSION);
    }

    public void separate() {
        String[] parts = EXPRESSION.trim().split("\\s*[+\\-*/]\\s*");
        partA.append(parts[0]);
        partB.append(parts[1]);
    }

    public String getExpr() {
        return EXPRESSION;
    }
}

