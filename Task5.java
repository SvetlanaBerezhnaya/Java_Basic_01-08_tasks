package com.epam;

import java.io.*;
import java.security.SecureRandom;
import java.util.Scanner;

public class Task5 {
    private static final String latinLettersLower = "abcdefghijklmnopqrstuvwxyz";
    private static final String latinLettersUpper = latinLettersLower.toUpperCase();
    private static final String digits = "0123456789";
    private static final String alphaNumericSymbols = latinLettersLower + latinLettersUpper + digits;
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) throws IOException {
        String FilePath = "D:\\Task5.txt";
        int wordCount = 0;
        try {
            FileWriter file = new FileWriter(FilePath);
            int numberOfLines = randomRange(2, 5);
            for (int i = 1; i <= numberOfLines; i++) {
                String line = "";
                int numberOfWordsPerLine = randomRange(1, 4);
                int numberOfWhitespaces = randomRange(1, 5);
                for (int j = 1; j <= numberOfWordsPerLine; j++) {
                    int wordLength = randomRange(1, 10);
                    line += generateRandomWhitespaces(numberOfWhitespaces);
                    line += generateRandomWord(wordLength);
                    line += generateRandomWhitespaces(numberOfWhitespaces);
                }
                file.write(line + "\n");
            }
            file.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }

        try {
            File file = new File(FilePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                str = str.trim();
                String[] parts = str.split(" ");
                for (int i = 0; i < parts.length; i++) {
                    if (!parts[i].isEmpty())
                        wordCount++;
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
        System.out.println("The file contains " + wordCount + " words.");
    }

    static int randomRange(int beginIndex, int endIndex) {
        int randomNumber = beginIndex + (int) (Math.random() * endIndex);
        return randomNumber;
    }

    public static String generateRandomWord(int length) {
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(alphaNumericSymbols.length());
            char rndChar = alphaNumericSymbols.charAt(rndCharAt);
            stringBuilder.append(rndChar);
        }
        return stringBuilder.toString();
    }

    public static String generateRandomWhitespaces(int length) {
        if (length < 1) throw new IllegalArgumentException();
        String randomWhitespaces = "";
        for (int i = 1; i <= length; i++)
            randomWhitespaces += " ";
        return randomWhitespaces;
    }
}