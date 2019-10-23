package com.epam;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter first version (enter \"exit\" to exit): ");
            String version1 = scanner.nextLine().trim();
            version1 = version1.replace(" ", "");
            version1 = version1.toLowerCase();
            if (version1.isEmpty()) {
                System.out.println("The string is empty.");
                System.out.println();
            } else if (version1.equals("exit")) {
                scanner.close();
                break;
            } else {
                System.out.print("Enter second version (enter \"exit\" to exit): ");
                String version2 = scanner.nextLine().trim();
                version2 = version2.replace(" ", "");
                version2 = version2.toLowerCase();
                if (version2.isEmpty()) {
                    System.out.println("The string is empty.");
                    System.out.println();
                } else if (version2.equals("exit")) {
                    scanner.close();
                    break;
                } else {
                    int compareResult = compareVersions(version1, version2);
                    if (compareResult == 0)
                        System.out.println("These versions \"" + version1 + "\" and \"" + version2 + "\" are the same.");
                    else if (compareResult == -1)
                        System.out.println("The version \"" + version1 + "\" less than \"" + version2 + "\" version.");
                    else if (compareResult == 1)
                        System.out.println("The version \"" + version1 + "\" greater than \"" + version2 + "\" version.");
                    System.out.println();
                }
            }
        }
    }

    public static int compareVersions(String version1, String version2) {
        String[] arrayVersion1 = version1.split("[.]");
        String[] arrayVersion2 = version2.split("[.]");
        int arrayVersionLengthMin = arrayVersion1.length < arrayVersion2.length ? arrayVersion1.length : arrayVersion2.length;
        try {
            for (int i = 0; i < arrayVersionLengthMin; i++) {
                int partVersion1 = Integer.parseInt(arrayVersion1[i]);
                int partVersion2 = Integer.parseInt(arrayVersion2[i]);
                if (partVersion1 < partVersion2) {
                    return -1;
                } else if (partVersion1 > partVersion2)
                    return 1;
            }
            if (arrayVersion1.length < arrayVersion2.length) {
                for (int i = arrayVersionLengthMin; i < arrayVersion2.length; i++) {
                    int partVersion2 = Integer.parseInt(arrayVersion2[i]);
                    if (partVersion2 > 0)
                        return -1;
                }
            } else if (arrayVersion1.length > arrayVersion2.length) {
                for (int i = arrayVersionLengthMin; i < arrayVersion1.length; i++) {
                    int partVersion1 = Integer.parseInt(arrayVersion1[i]);
                    if (partVersion1 > 0)
                        return 1;
                }
            }
            return 0;
        } catch (Exception ex) {
            System.out.println("Incorrect data input format.");
            return -2;
        }
    }
}