package com.hannoverdrei.yogurt;

import android.util.Log;

import java.util.LinkedList;

/**
 * Created by Tim on 17.09.2016.
 */
public class Order {

    private LinkedList<Ingredient> orderIngs; // because easy right now
    private double cost;
    public Order(LinkedList<Ingredient> orderIngs) {
        this.orderIngs = orderIngs;
    }

    public String sendOrderAsJSON() {
        String temp = "[";
        for (Ingredient i : orderIngs) {
            if (i.getValue() > 0) {
                temp = temp.concat("{\"id\":" + i.getId() + ",\"value\":" + i.getValue() + "},");
            }
        }
        temp = temp.substring(0, temp.length() - 1);
        temp = temp.concat("]");
        Log.d("yo", temp);
        return temp;
    }

    public int totalValue() {
        int totalValue = 0;
        for (Ingredient ing : orderIngs) {
            totalValue += ing.getValue();
        }
        return totalValue;
    }

    public double cost(int totalValue) {
        double cost;
        if (totalValue <= 25) {
            cost = 2.95;
        } else if (totalValue <= 50) {
            cost = 4.95;
        } else if (totalValue <= 100) {
            cost = 9.95;
        } else if (totalValue <= 150) {
            cost = 20.00;
        } else {
            cost = 0;
        }
        return cost;
    }
}
