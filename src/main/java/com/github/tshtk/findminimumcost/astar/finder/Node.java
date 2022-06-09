package com.github.tshtk.findminimumcost.astar.finder;

import com.github.tshtk.findminimumcost.astar.model.Cell;

public class Node implements Comparable<Node>{
    private final Cell cell;
    private int cost;
    private int predictedTotalCost;

    public Node(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }

    public void setPredictedTotalCost(int predictedTotalCost) {
        this.predictedTotalCost = predictedTotalCost;
    }

    @Override
    public int compareTo(final Node node) {
        return Integer.valueOf(predictedTotalCost).compareTo(node.predictedTotalCost);
    }
}
