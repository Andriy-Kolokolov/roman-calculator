package org.calculator;

import java.util.Scanner;

public class Launcher {
    private final Scanner scanner = new Scanner(System.in);
    public void run(){
        boolean running = true;
        while (running) {
            System.out.println("Enter expression using roman nums(format example: XX+MML) ->>> ");
            String input = scanner.nextLine();
            ProcessExpression processExpression = new ProcessExpression(input);
            System.out.println(processExpression.getExpr() + " = " + processExpression.getResult());
            System.out.println("--------- AGAIN? (N for exit) ---------");
            String againCheck = scanner.nextLine();
            if (againCheck.equalsIgnoreCase("n")){
                running = false;
            }
        }
    }
}
