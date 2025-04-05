package com.payments;
import java.time.LocalDate;
import java.time.Month;

interface D{
    static double discount(double amount){
        return 0.0;
    }
}

public class Seasonaldiscount implements D {
    private static Month m = LocalDate.now().getMonth();

    public static double discount(double amt){
        switch(m){
            case MARCH,APRIL,MAY:
                System.out.println("Applying Spring discount!");
                return amt * 0.95;
            case JUNE,JULY,AUGUST:
                System.out.println("Applying Summer discount!");
                return amt * 0.80;
            case SEPTEMBER,OCTOBER,NOVEMBER:
                System.out.println("Applying Autumn discount!");
                return amt * 0.90;
            case DECEMBER,JANUARY,FEBRUARY:
                System.out.println("Applying Winter discount!!");
                return amt * 0.75;
            default:
                return amt;
        }
    }



}




