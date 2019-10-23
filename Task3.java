package com.epam;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        long aN;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input integer number N > 0: ");
        if (scanner.hasNextLong()) {
            aN = scanner.nextLong();
            if (aN < 1) {
                System.out.println("The integer number N <= 0.");
                return;
            }
            if (aN > 92) {
                System.out.println("The " + aN + "-th Fibonacci number is too large.");
                return;
            }
            long res = numberFibonacci(aN, true);
            System.out.println("The " + aN + "-th Fibonacci number is: " + res);
        } else {
            String str = scanner.nextLine().trim();
            str = str.toLowerCase();
            if ((str.length() > 3) && (str.substring(0, 2).equals("0x"))) {
                str = str.substring(2);
            }
            try {
                aN = Long.parseLong(str, 16);
                System.out.println("The number N in decimal is: " + aN);
                if (aN > 92) {
                    System.out.println("The " + aN + "-th Fibonacci number is too large.");
                    return;
                }
                long res = numberFibonacci(aN, true);
                System.out.println("The " + aN + "-th Fibonacci number is: " + res);
            } catch (NumberFormatException e) {
                System.out.println("The string is not integer number.");
            }
        }
    }

    static long numberFibonacci(long aN, boolean outputDetail) {
        long a1 = 1;
        long a2 = 1;
        long a3 = 0;
        for (int i = 1; i <= aN; i++) {
            if (i == 1 || i == 2) {
                if (outputDetail) {
                    System.out.print("1 ");
                }
                a3 = 1;
            } else {
                a3 = a1 + a2;
                if (outputDetail) {
                    System.out.print(a3 + " ");
                }
                a1 = a2;
                a2 = a3;
            }
        }
        if (outputDetail) {
            System.out.println();
        }
        return a3;
    }
}