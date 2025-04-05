package com.payments;
import com.users.*;
import java.util.Scanner;

public class Payment {

    public static void pay() {
        double totalPayment = Customer.getTotalPayment();

        if (totalPayment == 0) {
            System.out.println("No products in the cart. Please add products before proceeding to payment.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Redeem offers!");
        System.out.println("1. Seasonal Discount");
        System.out.println("2. Coupon Code");
        System.out.println("3. Skip");

        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:
                System.out.println("Offer redeemed!");
                totalPayment = Seasonaldiscount.discount(totalPayment);
                break;
            case 2:
                System.out.println("Enter coupon code:");
                String code = sc.nextLine();
                Coupondiscount c = new Coupondiscount(code);
                totalPayment = c.discount(totalPayment);
                break;
            case 3:
                System.out.println("Proceeding...");
                break;
            default:
                System.out.println("Invalid choice. Proceeding without offers.");
        }



        System.out.println("Total amount to pay: ₹"+totalPayment);
        System.out.print("Enter payment amount: ");
        double amt = sc.nextDouble();

        if (amt == totalPayment) System.out.println("Payment successful! Thank you for shopping with us.");
        else System.out.println("Payment failed!");
    }
}
