package com.github.tshtk.findminimumcost.dijkstra;

import com.github.tshtk.findminimumcost.dijkstra.finder.CostFinder;
import com.github.tshtk.findminimumcost.dijkstra.model.Cell;
import com.github.tshtk.findminimumcost.utils.CodeToValueReader;

import java.io.IOException;
import java.util.Map;

public class Solution {
    public static final int SIZE = 4;
    public static final String PATH = "values.json";

    public static int getResult(final String stringCodes, final String thing) throws IOException {
        Map<Character, Integer> codeToValue = CodeToValueReader.fromFile(PATH).get(thing);
        Cell[][] grid = CostFinder.createGrid(SIZE, stringCodes, codeToValue);
        Cell firstCell = grid[0][0];
        firstCell.setCost(0);
        Cell lastCell = grid[SIZE - 1][SIZE - 1];
        CostFinder.fillCostDiagonally(grid);
        return lastCell.getCost() + lastCell.getValue() - firstCell.getValue();
    }
}
