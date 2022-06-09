package com.github.tshtk.findminimumcost.dijkstra.finder;

import com.github.tshtk.findminimumcost.dijkstra.model.Cell;

import java.util.Map;

public class CostFinder {
    public static Cell[][] createGrid(int size, String stringCodes, Map<Character, Integer> codeToValue) {
        char[] codes = stringCodes.toCharArray();
        Cell[][] grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();
                int value = codeToValue.get(codes[i * size + j]);
                cell.setValue(value);
                grid[i][j] = cell;
            }
        }
        return grid;
    }

    public static void fillCostDiagonally(Cell[][] grid) {
        int size = grid.length;
        for (int k = 0; k < 2 * size - 1; k++) {
            int start = k < size ? 0 : k - size + 1;
            int stop = k < size ? k + 1 : size;
            for (int i = start; i < stop; i++) {
                int j = k - i;
                setCost(grid, i, j);
            }
        }
    }

    private static void setCost(Cell[][] grid, int x, int y) {
        int size = grid.length;
        Cell cell = grid[x][y];
        int cellCost = cell.getCost();
        int cellValue = cell.getValue();
        if (x < size - 1) {
            Cell cellRight = grid[x + 1][y];
            if (cellRight.getCost() > cellCost + cellValue) {
                cellRight.setCost(cellCost + cellValue);
            }
        }
        if (y < size - 1) {
            Cell cellDown = grid[x][y + 1];
            if (cellDown.getCost() > cellCost + cellValue) {
                cellDown.setCost(cellCost + cellValue);
            }
        }
    }
}
