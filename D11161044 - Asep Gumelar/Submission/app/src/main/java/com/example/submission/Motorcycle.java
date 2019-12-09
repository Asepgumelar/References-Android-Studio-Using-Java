package com.example.submission;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.DrawableRes;

class Motorcycle {
    private final String title;
    private final String price;
    private final String desc;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String PRICE_KEY = "Price";
    static final String DESC_KEY = "Desc";
    static final String IMAGE_KEY = "Image Resource";

    Motorcycle(String title, String price, String desc, int imageResource) {
        this.title = title;
        this.price = price;
        this.desc = desc;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }
    String getPrice() {
        return price;
    }
    String getDesc() { return desc; }
    int getImageResource() {
        return imageResource;
    }

    static Intent starter(Context context, String title, String price, String desc, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(PRICE_KEY, price);
        detailIntent.putExtra(DESC_KEY, desc);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }

}
