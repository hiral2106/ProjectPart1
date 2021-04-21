package com.example.foodpanda.Models;

public class OrdersModel {

    //************Step-20***********// --------step 21----create OrdersAdapter.java
    int orderImageOS;
    String soldItemNameOS, priceOS, orderNumberOS;
    //Generate Constructors

    public OrdersModel(int orderImageOS, String soldItemNameOS, String priceOS, String orderNumberOS) {
        this.orderImageOS = orderImageOS;
        this.soldItemNameOS = soldItemNameOS;
        this.priceOS = priceOS;
        this.orderNumberOS = orderNumberOS;
    }

    public OrdersModel() {

    }
    //Generate setters and getters

    public int getOrderImageOS() {
        return orderImageOS;
    }

    public void setOrderImageOS(int orderImageOS) {
        this.orderImageOS = orderImageOS;
    }

    public String getSoldItemNameOS() {
        return soldItemNameOS;
    }

    public void setSoldItemNameOS(String soldItemNameOS) {
        this.soldItemNameOS = soldItemNameOS;
    }

    public String getPriceOS() {
        return priceOS;
    }

    public void setPriceOS(String priceOS) {
        this.priceOS = priceOS;
    }

    public String getOrderNumberOS() {
        return orderNumberOS;
    }

    public void setOrderNumberOS(String orderNumberOS) {
        this.orderNumberOS = orderNumberOS;
    }

}
