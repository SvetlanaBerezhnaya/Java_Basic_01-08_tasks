package com.epam;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Task8 {
    public static void main(String[] args) {
        String FilePath = "D:\\Task8.txt";
        try {
            File file = new File(FilePath);
            Scanner scanner = new Scanner(file);
            String Braces = "";
            String bracesSample = "()[]{}<>";
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if (bracesSample.contains("" + ch))
                        Braces += "" + ch;
                }
            }
            boolean isBracesBalanced = isBracesBalanced(Braces);
            if (isBracesBalanced)
                System.out.println("The braces \"" + Braces + "\" are balanced.");
            else
                System.out.println("The braces \"" + Braces + "\" are not balanced.");
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }

    public static boolean isBracesBalanced(String s) {
        HashMap<Character, Character> BracesMap = new HashMap<Character, Character>();
        BracesMap.put(')', '(');
        BracesMap.put(']', '[');
        BracesMap.put('}', '{');
        BracesMap.put('>', '<');
        HashSet<Character> openBracketSet = new HashSet<Character>(
                BracesMap.values());
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (openBracketSet.contains(cur)) {
                stack.push(cur);
            } else if (BracesMap.keySet().contains(cur)) {
                if (stack.isEmpty())
                    return false;
                if (BracesMap.get(cur) != stack.peek())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}