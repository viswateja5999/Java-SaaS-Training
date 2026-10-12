package com.saas.employee.util;

import java.util.Scanner;

public final class InputUtil {

    private static final Scanner SCANNER =
            new Scanner(System.in);

    private InputUtil() {
    }

    public static String readString(String message) {
        System.out.print(message);
        return SCANNER.nextLine().trim();
    }

    public static int readInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(readString(message));
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a whole number.");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(readString(message));
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a number.");
            }
        }
    }
}