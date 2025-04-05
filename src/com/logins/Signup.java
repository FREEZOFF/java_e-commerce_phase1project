package com.logins;

import java.util.Scanner;
import java.io.*;

public class Signup{
    public static void inputs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String naam = sc.nextLine();
        System.out.println("Enter your email: ");
        String mail = sc.nextLine();
        String pswd,confpswd;
        while (true){
            System.out.println("Enter your password: ");
            pswd = sc.nextLine();
            if (pswd.equals("")) System.exit(0);
            System.out.println("Confirm password: ");
            confpswd = sc.nextLine();
            if (pswd.equals(confpswd)) break;
            else System.out.println("Passwords do not match");
        }
        save(naam,mail,pswd);
    }

    private static void save(String name, String mail, String pswd){
        try (FileWriter fw = new FileWriter("UserInfo.txt", true)) {
            fw.write("Email: " + mail + ", Name: " + name + ", Password: " + pswd+ "\n");
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }
}