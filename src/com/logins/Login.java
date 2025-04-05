package com.logins;

import java.util.Scanner;
import java.io.*;
public class Login {

    public static boolean inputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        return check(email, password);
    }

    private static boolean check(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Email: " + email+",") && line.endsWith("Password: " + password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
        return false;
    }
}

