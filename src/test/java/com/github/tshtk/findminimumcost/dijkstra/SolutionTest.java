package com.github.tshtk.findminimumcost.dijkstra;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void shouldCalculateResult() throws IOException {
        String stringValues;
        String thing;
        int expected;
        int actual;

        stringValues = "STWSWTPPTPTTPWPP";
        thing = "Human";
        expected = 10;
        actual = Solution.getResult(stringValues, thing);
        assertEquals(expected, actual);

        stringValues = "SWWTSSWPPWSTTSWP";
        thing = "Woodman";
        expected = 14;
        actual = Solution.getResult(stringValues, thing);
        assertEquals(expected, actual);

        stringValues = "TTSTPTWTTTPTWTSW";
        thing = "Swamper";
        expected = 15;
        actual = Solution.getResult(stringValues, thing);
        assertEquals(expected, actual);

        stringValues = "SPWPSTWSPSSSWTWP";
        thing = "Human";
        expected = 13;
        actual = Solution.getResult(stringValues, thing);
        assertEquals(expected, actual);

        stringValues = "PPSSSPSSSPPSSSPP";
        thing = "Human";
        expected = 6;
        actual = Solution.getResult(stringValues, thing);
        assertEquals(expected, actual);
    }

}