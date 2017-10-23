package edu.bsu.cs222.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private int elfTotal;
    private int dwarfTotal;
    private int humanTotal;
    private int gnomeTotal;
    private int dragonbornTotal;
    private int halfelfTotal;
    private int halforcTotal;
    private int tieflingTotal;
    private int halflingTotal;

    private int barbarianTotal;
    private int bardTotal;
    private int clericTotal;
    private int druidTotal;
    private int fighterTotal;
    private int monkTotal;
    private int paladinTotal;
    private int rangerTotal;
    private int rogueTotal;
    private int sorcererTotal;
    private int warlockTotal;
    private int wizardTotal;

    private ArrayList<String> raceFileNamesList = new ArrayList<String>() {
        {
            add("Elf.txt");
            add("Dwarf");
            add("Gnome");
            add("Human");
            add("Tiefling");
            add("Dragonborn");
            add("Halfling");
            add("Half-Orc");
            add("Half-Elf");
        }
    };

    private ArrayList<String> classFileNamesList = new ArrayList<String>() {
        {
            add("Barbarian");
            add("Bard");
            add("Cleric");
            add("Druid");
            add("Fighter");
            add("Monk");
            add("Paladin");
            add("Ranger");
            add("Rogue");
            add("Sorcerer");
            add("Warlock");
            add("Wizard");
        }
    };

    public void findSimilarities() {
        ResponseParser parser = new ResponseParser();
        SentimentAnalysisParser sentimentAnalysisParser = new SentimentAnalysisParser();

        ArrayList<Response> resultsList = sentimentAnalysisParser.getResponseList();
        List<String> mapperResult;

        // Responses regarding class
        for (int i = 1; i <= 5; i++) {
            mapperResult = parser.splitResponse(resultsList.get(i));
        }

        // Responses regarding race
        for (int i = 6; i <= 10; i++) {
            mapperResult = parser.splitResponse(resultsList.get(i));
        }
    }

    public String processTextFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String fileContents = null;
        while (reader.readLine() != null) {
            fileContents += reader.readLine();
        }
        reader.close();
        return fileContents;
    }
}