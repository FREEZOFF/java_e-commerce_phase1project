package com.users;
import java.io.*;
import java.util.*;

public class Customer {
    private static double totalPayment = 0.0;

    public static double getTotalPayment() {
        return totalPayment;
    }

    public static void addtocart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Product ID to add to cart: ");
        int shoeID = sc.nextInt();
        double price = getPrice(shoeID);
        totalPayment += price;
        System.out.println("Product added to cart! Price: ₹"+price);
    }

    public static void deletefromcart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Product ID to remove from cart: ");
        int shoeID = sc.nextInt();
        double price = getPrice(shoeID);
        if (price > 0) {
            totalPayment -= price;
            System.out.println("Product removed from cart. Amount deducted: ₹"+price);
        }
    }

    private static double getPrice(int shoeID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Shoes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split(", ");
                if (Integer.parseInt(p[0]) == shoeID) {
                    return Double.parseDouble(p[5]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
        return 0;
    }

    public static void totalprice() {
        System.out.println("Total Payment: ₹"+totalPayment);
    }

    public static void browseShoe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Search for shoes: ");
        String keyword = sc.nextLine().toLowerCase();
        try (BufferedReader reader = new BufferedReader(new FileReader("Shoes.txt"))) {
            String line;
            System.out.println("Search Results:");
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(", ");
                if (arr.length >= 2) {
                    String shoename = arr[1].toLowerCase();
                    if (shoename.contains(keyword)) {
                        System.out.println("Shoe ID: "+arr[0]+", Name: "+arr[1]+", Type: "+arr[2]+", Color: "+arr[3]+", Size: "+arr[4]+", Price: ₹"+arr[5]);
                    }
                }
            }
            System.out.println("-----------------------------------");

        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }
    
}
