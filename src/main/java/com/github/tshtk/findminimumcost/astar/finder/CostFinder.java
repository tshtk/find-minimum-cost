package com.github.tshtk.findminimumcost.astar.finder;

import com.github.tshtk.findminimumcost.astar.model.Cell;

import java.util.HashSet;
import java.util.PriorityQueue;

public class CostFinder {
    public static int find(Grid grid, Cell sourceCell, Cell targetCell) {
        int minValue = grid.getMinValue();
        PriorityQueue<Node> frontier = new PriorityQueue<>();
        HashSet<Cell> visitedCells = new HashSet<>();
        Node targetNode = new Node(targetCell);
        Node sourceNode = new Node(sourceCell);
        frontier.add(sourceNode);
        visitedCells.add(sourceCell);
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (currentNode.getCell().equals(targetCell)) {
                return currentNode.getCost();
            }
            int currentNodeValue = currentNode.getCell().getValue();
            int currentNodeCost = currentNode.getCost();
            for (Cell nextCell : currentNode.getCell().getNext()) {
                if (!visitedCells.contains(nextCell)) {
                    Node nextNode = new Node(nextCell);
                    nextNode.setCost(currentNodeValue + currentNodeCost);
                    setPredicateTotalCost(nextNode, targetNode, minValue);
                    frontier.add(nextNode);
                    visitedCells.add(nextCell);
                }
            }
        }
        return -1;
    }

    private static void setPredicateTotalCost(Node node, Node targetNode, int minValue) {
        Cell targetCell = targetNode.getCell();
        Cell cell = node.getCell();
        int length = (targetCell.getX() - cell.getX()) + (targetCell.getY() - cell.getY());
        int predictedTotalCost = node.getCost() + cell.getValue() + minValue * (length -1);
        node.setPredictedTotalCost(predictedTotalCost);
    }
}
