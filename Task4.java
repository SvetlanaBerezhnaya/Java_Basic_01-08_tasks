package com.epam;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter expression for calculation (enter \"exit\" to exit): ");
            String str = scanner.nextLine().trim();
            str = str.replace(" ", "");
            str = str.toLowerCase();
            if (str.isEmpty()) {
                System.out.println("The string is empty.");
                System.out.println();
            } else if (str.equals("exit")) {
                scanner.close();
                break;
            } else {
                Operation op = Operation.ADDITION;
                int indexOperation = 0;
                if (str.lastIndexOf('+') > 0) {
                    if ((str.indexOf('+') == 0) || (str.indexOf('+') == str.lastIndexOf('+'))) {
                        indexOperation = str.lastIndexOf('+');
                    }
                }
                if (str.lastIndexOf('-') > 0) {
                    if ((str.indexOf('-') == 0) || (str.indexOf('-') == str.lastIndexOf('-'))) {
                        op = Operation.SUBTRACTION;
                        indexOperation = str.lastIndexOf('-');
                    }
                }
                if (indexOperation > 0) {
                    String str1 = str.substring(0, indexOperation).trim();
                    String str2 = str.substring(indexOperation + 1).trim();
                    try {
                        int operand1 = Integer.parseInt(str1);
                        int operand2 = Integer.parseInt(str2);
                        System.out.println("The calculation result is: " + op.action(operand1, operand2));
                        System.out.println();
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data input format.");
                        System.out.println();
                    }
                } else {
                    System.out.println("Incorrect data input format.");
                    System.out.println();
                }
            }
        }
    }
}

enum Operation {
    ADDITION {
        public long action(int x, int y) {
            return ((long) x) + ((long) y);
        }
    },
    SUBTRACTION {
        public long action(int x, int y) {
            return ((long) x) - ((long) y);
        }
    };

    public abstract long action(int x, int y);
}