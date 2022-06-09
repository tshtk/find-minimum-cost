package com.github.tshtk.findminimumcost.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class CodeToValueReader {
    public static Map<String, Map<Character, Integer>> fromFile(String path) throws IOException {
        Map<String, Map<Character, Integer>> values;
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8)) {
            Type type = new TypeToken<Map<String, Map<Character, Integer>>>(){}.getType();
            values = new Gson().fromJson(reader, type);
        }
        return values;
    }
}
