package com.github.tshtk.findminimumcost.astar.model;

import java.util.ArrayList;
import java.util.List;

public class Cell{
    private final List<Cell> next;
    private final int value;
    private final int x;
    private final int y;

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.next = new ArrayList<>();
    }

    public List<Cell> getNext() {
        return next;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }
}
