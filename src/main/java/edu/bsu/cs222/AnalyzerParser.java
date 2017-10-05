package edu.bsu.cs222;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class AnalyzerParser {
    public void parseStuff(InputStream inputStream) {
        JsonParser parser = new JsonParser();
        //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        System.out.println(rootElement);
    }
}