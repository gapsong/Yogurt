package com.hannoverdrei.yogurt;

import android.media.Image;

/**
 * Created by Tim on 17.09.2016.
 */
public class Ingredient {


    private String name;

    public void setValue(int value) {
        this.value = value;
    }

    private int value;
    private Image image;

    public Ingredient(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


}
