package com.epam;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please input latin alphanumeric string (enter \"exit\" to exit): ");
            String str = scanner.nextLine().trim();
            str = str.toLowerCase();
            if (str.isEmpty()) {
                System.out.println("The string is empty.");
            } else if (str.equals("exit")) {
                scanner.close();
                break;
            } else if (!str.matches(".*[a-z0-9]")) {
                System.out.println("The string is not latin alphanumeric.");
            } else {
                char firstCharacter = str.charAt(0);
                boolean isDigit = Character.isDigit(firstCharacter);
                if (isDigit) {
                    System.out.println("The string starts with digit.");
                } else {
                    String vowels = "aeiouy";
                    int vowelIndex = vowels.indexOf(firstCharacter);
                    if (vowelIndex != -1) {
                        System.out.println("The string starts with vowel.");
                    } else {
                        System.out.println("The string starts with consonant.");
                    }
                }
            }
        }
    }
}