package org.calculator;

public class ProcessExpression {

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
        }
        throw new InvalidExpressionException("Invalid expression: " + EXPRESSION);
    }

    private boolean expressionIsValid() {
        boolean lengthValid = EXPRESSION.length() > 2;
        String regex = "^\\s*[IVXLCDM]+\\s*[+\\-*/]\\s*[IVXLCDM]+\\s*$";
        return lengthValid && EXPRESSION.matches(regex);
    }

    private void checkOperation() {
        for (char ch : EXPRESSION.toCharArray()) {
            if (ch == Operation.ADDITION.getChar()) {
                setOperation(ch);
                break;
            }
            if (ch == Operation.SUBTRACTION.getChar()) {
                setOperation(ch);
                break;
            }
            if (ch == Operation.MULTIPLICATION.getChar()) {
                setOperation(ch);
                break;
            }
            if (ch == Operation.DIVISION.getChar()) {
                setOperation(ch);
                break;
            }
        }
    }

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

    public void separate() {
        String[] parts = EXPRESSION.trim().split("\\s*[+\\-*/]\\s*");
        PART_A.append(parts[0]);
        PART_B.append(parts[1]);
    }

    private void setOperation(Character operation) {
        this.operation = operation;
    }

    public String getExpr() {
        return EXPRESSION;
    }
}

