package com.p92practicalexam2dawnnarikkattumathews;

public class RestaurantCart {
    String item_name;
    String item_price;
    String item_ingredients;
    int item_image;

    public RestaurantCart() {
    }


    public RestaurantCart(String item_name, String item_price, String item_ingredients, int item_image) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_ingredients = item_ingredients;
        this.item_image = item_image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_ingredients() {
        return item_ingredients;
    }

    public void setItem_ingredients(String item_ingredients) {
        this.item_ingredients = item_ingredients;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}
