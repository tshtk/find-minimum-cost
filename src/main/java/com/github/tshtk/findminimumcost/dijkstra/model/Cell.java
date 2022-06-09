package com.github.tshtk.findminimumcost.dijkstra.model;

public class Cell {
    private int value;
    private int cost = Integer.MAX_VALUE;

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }
}
