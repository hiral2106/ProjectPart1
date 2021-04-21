package com.example.foodpanda.Models;

public class MainModel {

    //--------------Step1-------------//
    int image; //it is int because we will be getting img from drawables

    //Price is in string -- it will be converted into int by database
    String name, price, description;

    //---------Step2-----------//
    //Generate Constrocter and getter setters

    public MainModel(int image, String name, String price, String description) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
