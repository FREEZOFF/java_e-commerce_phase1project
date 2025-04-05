package com.Main;
import com.logins.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.users.*;
import com.payments.*;

public class Main {
    static void loginsystem(String answer) {
        if (answer.equals("y")) {
            Signup.inputs();
            System.out.println("Registration Successful!");
            System.exit(0);
        }
        else if (answer.equals("n")) {
            if (Login.inputs()) System.out.println("Login successful! ");
            else {
                System.out.println("Invalid login credentials.");
                System.exit(0);
            }
        }
        else {
            System.out.println("Invalid Input.");
            System.exit(0);
        }
    }
    static void AdminMenu() {
        while (true) {
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Update product");
            System.out.println("4. Exit");
            Scanner inp = new Scanner(System.in);
            System.out.println("Enter operation number: ");
            switch (inp.nextInt()) {
                case 1:
                    Admin.addShoe();
                    break;
                case 2:
                    Admin.deleteShoe();
                    break;
                case 3:
                    Admin.updateShoe();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid operation number.");
            }
        }
    }
    static void CustomerMenu(){
        while (true){
            System.out.println("1. Browse shoes");
            System.out.println("2. Add to cart");
            System.out.println("3. Remove from cart");
            System.out.println("4. Payment gateway");
            System.out.println("5. Exit");
            Scanner inp = new Scanner(System.in);
            System.out.println("What would you like to do? ");
            switch (inp.nextInt()) {
                case 1:
                    Customer.browseShoe();
                    break;
                case 2:
                    Customer.addtocart();
                    Customer.totalprice();
                    break;
                case 3:
                    Customer.deletefromcart();
                    Customer.totalprice();
                    break;
                case 4:
                    Payment.pay();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Shoes E-Commerce.\nLet's get you started!");
        System.out.println("Are you a new user(y/n): ");
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if (inp.equals("admin_uar")) {
            try{AdminMenu();}
            catch(InputMismatchException e){
                System.out.println("Error occurred! Invalid input.");}
        }
        else loginsystem(inp);
        try{CustomerMenu();}
        catch(InputMismatchException e){
            System.out.println("Error occurred! Invalid input.");}
    }
}

