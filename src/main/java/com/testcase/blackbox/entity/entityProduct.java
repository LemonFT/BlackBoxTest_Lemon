package com.testcase.blackbox.entity;

public class entityProduct {
    private String imgUrl, name, price, title, amount, type;
    public entityProduct(String imgUrl, String name, String price, String title, String amount, String type){
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.title = title;
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
    
}

