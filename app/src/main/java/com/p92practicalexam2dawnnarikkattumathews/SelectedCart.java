package com.p92practicalexam2dawnnarikkattumathews;

public class SelectedCart {
    String item_name;
    String item_quantity;
    String item_price;
    String item_total_price;
    int item_image;

    public SelectedCart() {
    }

    public SelectedCart(String item_name, String item_quantity, String item_price, String item_total_price, int item_image) {
        this.item_name = item_name;
        this.item_quantity = item_quantity;
        this.item_price = item_price;
        this.item_total_price = item_total_price;
        this.item_image = item_image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(String item_quantity) {
        this.item_quantity = item_quantity;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_total_price() {
        return item_total_price;
    }

    public void setItem_total_price(String item_total_price) {
        this.item_total_price = item_total_price;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}
