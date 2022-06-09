package com.github.tshtk.findminimumcost.astar;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SolutionAStarTest {
    @Test
    void shouldCalculateResult() throws IOException, InterruptedException {
        String stringValues;
        String thing;
        int expected;
        int actual;

        stringValues = "STWSWTPPTPTTPWPP";
        thing = "Human";
        expected = 10;
        actual = SolutionAStar.getResult(stringValues, thing);
        assertEquals(expected, actual);

        stringValues = "SWWTSSWPPWSTTSWP";
        thing = "Woodman";
        expected = 14;
        actual = SolutionAStar.getResult(stringValues, thing);
        assertEquals(expected, actual);

        stringValues = "TTSTPTWTTTPTWTSW";
        thing = "Swamper";
        expected = 15;
        actual = SolutionAStar.getResult(stringValues, thing);
        assertEquals(expected, actual);

        stringValues = "SPWPSTWSPSSSWTWP";
        thing = "Human";
        expected = 13;
        actual = SolutionAStar.getResult(stringValues, thing);
        assertEquals(expected, actual);

        stringValues = "PPSSSPSSSPPSSSPP";
        thing = "Human";
        expected = 6;
        actual = SolutionAStar.getResult(stringValues, thing);
        assertEquals(expected, actual);
    }
}