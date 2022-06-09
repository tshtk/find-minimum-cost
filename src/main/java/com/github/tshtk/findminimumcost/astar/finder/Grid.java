package com.github.tshtk.findminimumcost.astar.finder;

import com.github.tshtk.findminimumcost.astar.model.Cell;

import java.util.Map;

public class Grid {
    private final Cell[][] cells;
    private final int minValue;

    public static Grid create(int size, char[] codes, Map<Character, Integer> codeToValue) {
        Cell[][] cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = codeToValue.get(codes[i * size + j]);
                cells[i][j] = new Cell(i, j, value);
                if (i > 0) {
                    cells[i-1][j].getNext().add(cells[i][j]);
                }
                if (j > 0) {
                    cells[i][j-1].getNext().add(cells[i][j]);
                }
            }
        }
        int minValue = codeToValue.values()
            .stream()
            .min(Integer::compare)
            .get();
       return new Grid(cells, minValue);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getMinValue() {
        return minValue;
    }

    private Grid(Cell[][] cells, int minValue) {
        this.cells = cells;
        this.minValue = minValue;
    }
}
