package com.hannoverdrei.yogurt;
import java.util.LinkedList;

/**
 * Created by Tim on 17.09.2016.
 */
public class Order {

    private LinkedList<Ingredient> orderIngs = new LinkedList(); // because easy right now
    private int totalValue;
    private double cost;

    public Order(LinkedList<Ingredient> orderIngs, int totalValue, double cost) {
        this.orderIngs = orderIngs;
        this.totalValue = totalValue;
        this.cost = cost;
    }
}
