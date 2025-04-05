package com.shoes;

public class Shoe{
    public String type,name,color;
    public int size,shoeID;
    public double price;

    public Shoe(int shoeID,String name, String type, String color, int size,  double price) {
        this.type = type;
        this.name = name;
        this.color = color;
        this.size = size;
        this.shoeID = shoeID;
        this.price = price;
    }

    public String toString(){
        return shoeID+", "+name+", "+type+", "+color+", "+size+", "+price;
    }
}
