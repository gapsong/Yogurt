package com.hannoverdrei.yogurt;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Tim on 17.09.2016.
 */
public class OrderUtil {
    public static int totalValue(LinkedList<Ingredient> ingList) {
        int totalValue = 0;
        for (Ingredient ing : ingList) {
            totalValue += ing.getValue();
        }
        return totalValue;
    }

    public static double cost(int totalValue) {
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

    public static String genJSON(LinkedList<Ingredient> ing) {
        String j = "{\"data\" : ";
        for (Ingredient i : ing) {
            if(i.getValue() > 0) {
                j.concat(",{\"id\":"+ i.getId() +",\"value\":" + i.getValue() + "}");
            }
        }
        j.concat("]}");
        return j;

    }
}


