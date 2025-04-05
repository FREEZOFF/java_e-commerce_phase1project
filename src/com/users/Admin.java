package com.users;
import com.shoes.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Admin{

    public static void addShoe()
    {
        ArrayList<Shoe> s = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many products would you like to add? ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("Enter the ID of the shoe");
            int shoeID = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the name of the shoe");
            String name = sc.nextLine();
            System.out.println("Enter the type of the shoe");
            String type = sc.nextLine();
            System.out.println("Enter the color of the shoe");
            String color = sc.nextLine();
            System.out.println("Enter the size of the shoe");
            int size = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the price of the shoe");
            double price = sc.nextDouble();
            sc.nextLine();
            s.add(new Shoe(shoeID, name, type, color, size, price));
        }

        save(s,true);
    }


    public static void updateShoe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of the product to update:");
        int id = sc.nextInt();

        ArrayList<String> content = new ArrayList<>();
        boolean f = false;

        try (BufferedReader reader= new BufferedReader(new FileReader("Shoes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(id+",")) {
                    f = true;
                    System.out.println("1. Name\n2. Type\n3. Color\n4. Size\n5. Price\n6. Exit");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    String[] arr = line.split(", ");

                    switch (choice) {
                        case 1:
                            System.out.print("Enter new name: ");
                            arr[1] = sc.nextLine();
                            break;
                        case 2:
                            System.out.print("Enter new type: ");
                            arr[2] = sc.nextLine();
                            break;
                        case 3:
                            System.out.print("Enter new color: ");
                            arr[3] = sc.nextLine();
                            break;
                        case 4:
                            System.out.print("Enter new size: ");
                            arr[4] = sc.nextLine();
                            break;
                        case 5:
                            System.out.print("Enter new price: ");
                            arr[5] = sc.nextLine();
                            break;
                        case 6:
                            System.out.println("No changes made.");
                            break;
                        default:
                            System.out.println("Invalid option.");
                            return;
                    }

                    line = String.join(", ", arr);
                }
                content.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred!");
            return;
        }
        if (!f) {
            System.out.println("Shoe ID not found.");
            return;
        }
        save(content);
        System.out.println("Update successful.");
    }

    private static void save(ArrayList<Shoe> s, boolean append) {
        try (FileWriter fw = new FileWriter("Shoes.txt", append)) {
            for (Shoe shoe : s) {
                fw.write(shoe.toString() + "\n");
            }
            System.out.println("Product added successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }
    private static void save(ArrayList<String> l) {
        try (FileWriter fw = new FileWriter("Shoes.txt", false)) {
            for (String line : l) {
                fw.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }

    public static void deleteShoe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of the product to delete:");
        int id = sc.nextInt();

        ArrayList<String> content = new ArrayList<>();
        boolean f =false;

        try (BufferedReader reader = new BufferedReader(new FileReader("Shoes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(id+",")){
                    content.add(line);
                }
                else f =true;
            }
        }
        catch (IOException e) {
            System.out.println("Error occurred!");
            return;
        }
        if (!f){
            System.out.println("Product ID not found.");
            return;
        }
        save(content);
        System.out.println("Product deleted successfully.");
    }
}
