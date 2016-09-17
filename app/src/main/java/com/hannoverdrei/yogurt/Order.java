package com.hannoverdrei.yogurt;

import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Tim on 17.09.2016.
 */
public class Order {

    private static LinkedList orderIngs = new LinkedList();
    private static int totalValue;

    public Order(LinkedList orderIngs, int totalValue) { // User Data add
        this.orderIngs = orderIngs;
        this.totalValue = totalValue;
    }

    private static void Adding(String name, int value, TextView price) {
        Ingridient ing = new Ingridient(name,value);

        totalValue += value;
        if (totalValue <= 25) {
            price.setText("2,50");
        } else if (totalValue <= 50) {
            price.setText("4,20");
        } else if ( totalValue <= 75) {
            price.setText("6,50");
        } else if ( totalValue <= 100) {
            price.setText("10,00");
        }
        orderIngs.addLast(ing);
    }

    private static void Delete(Ingridient ing) {
        orderIngs.remove(ing);
    }


}
