package com.payments;


public class Coupondiscount implements D{
    private static String code;

    public Coupondiscount(String code) {
        this.code = code;
    }

    public static double discount(double amt) {
        if (code.equalsIgnoreCase("SAVE1000")) {
            System.out.println("Applying code...");
            amt = amt -1000;
            if (amt < 0) {
                System.out.println("Can't apply this code.");
                return amt+1000;
            }
            return amt;
        }
        else if (code.equalsIgnoreCase("SAVE5000")) {
            System.out.println("Applying code...");
            amt = amt -5000;
            if (amt < 0) {
                System.out.println("Can't apply this code.");
                return amt+5000;
            }
            return amt;
        }
        else {
            System.out.println("Invalid coupon code.");
            return amt;
        }
    }
}