package com.hannoverdrei.yogurt;

import android.media.Image;

/**
 * Created by Tim on 17.09.2016.
 */
public class Ingredient {


    private String name;
    private int value;
    private int id;
    private Image image;


    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public Ingredient(String name, int id) {
        this.name = name;
        this.value = 0;
        this.id = id;
    }
}
