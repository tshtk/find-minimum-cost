package com.github.tshtk.findminimumcost;

import com.github.tshtk.findminimumcost.astar.SolutionAStar;
import com.github.tshtk.findminimumcost.dijkstra.Solution;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String stringValues = "STWSWTPPTPTTPWPP";
        String thing = "Human";

        System.out.println(Solution.getResult(stringValues, thing));

        System.out.println(SolutionAStar.getResult(stringValues, thing));
    }
}
