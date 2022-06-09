package com.github.tshtk.findminimumcost.astar;

import com.github.tshtk.findminimumcost.astar.finder.CostFinder;
import com.github.tshtk.findminimumcost.astar.finder.Grid;
import com.github.tshtk.findminimumcost.astar.model.Cell;
import com.github.tshtk.findminimumcost.utils.CodeToValueReader;

import java.io.IOException;
import java.util.Map;

public class SolutionAStar {
    public static final int SIZE = 4;
    public static final String PATH = "values.json";

    public static int getResult(String stringCodes, String thing) throws IOException {
        Map<Character, Integer> codeToValue = CodeToValueReader.fromFile(PATH).get(thing);
        Grid grid = Grid.create(SIZE, stringCodes.toCharArray(), codeToValue);
        Cell[][] cells = grid.getCells();
        Cell sourceCell = cells[0][0];
        Cell targetCell = cells[SIZE-1][SIZE-1];
        int cost = CostFinder.find(grid, sourceCell, targetCell);
        return cost - sourceCell.getValue() + targetCell.getValue();
    }


}
