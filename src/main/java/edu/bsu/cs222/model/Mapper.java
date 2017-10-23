package edu.bsu.cs222.model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Mapper {

    private ArrayList<String> raceFileNamesList = new ArrayList<String>() {
        {
            add("Elf.txt");
            add("Dwarf.txt");
            add("Gnome.txt");
            add("Human.txt");
            add("Tiefling.txt");
            add("Dragonborn.txt");
            add("Halfling.txt");
            add("Half-Orc.txt");
            add("Half-Elf.txt");
        }
    };

    private ArrayList<String> classFileNamesList = new ArrayList<String>() {
        {
            add("Barbarian.txt");
            add("Bard.txt");
            add("Cleric.txt");
            add("Druid.txt");
            add("Fighter.txt");
            add("Monk.txt");
            add("Paladin.txt");
            add("Ranger.txt");
            add("Rogue.txt");
            add("Sorcerer.txt");
            add("Warlock.txt");
            add("Wizard.txt");
        }
    };

    private ArrayList<ArrayList<String>> responseWordList = new ArrayList<>();
    private ArrayList<Response> responseList = new ArrayList<>();
    private HashMap<String, Integer> comparisonResultList = new HashMap<>();
    private HashMap<String, String> allFileContents = new HashMap<>();

    public void startMapper(ArrayList<Response> responseList) throws IOException {
        this.responseList = responseList;
        parseClass();
        parseRace();
    }

    public void findSimilarities(ArrayList<ArrayList<String>> responseWordList, String category) throws IOException {
        ArrayList<String> categoryFileNamesList = new ArrayList<>();
        if (category.equals("class")) {
            categoryFileNamesList = classFileNamesList;
        } else if (category.equals("race")) {
            categoryFileNamesList = raceFileNamesList;
        }

        ArrayList<String> fileContentsList = parseFileContents(categoryFileNamesList);

        for (ArrayList<String> response : responseWordList) {
            int index = 0;

            for (String contents : fileContentsList) {

                for (String word : response) {
                    int counter = 0;

                    if (contents.toLowerCase().contains(word.toLowerCase())) {
                        counter++;
                    }
                    comparisonResultList.put(categoryFileNamesList.get(index), counter);
                }
                if (index != categoryFileNamesList.size() - 1) {
                    index++;
                }
            }
        }
        for (String contents : fileContentsList) {
            System.out.println(contents);
        }

        System.out.print(comparisonResultList.get("Fighter.txt"));
    }

    private ArrayList<String> parseFileContents(ArrayList<String> categoryFileNamesList) throws IOException {
        ArrayList<String> fileContentsList = new ArrayList<>();
        for (String fileName : categoryFileNamesList) {
            processTextFile(fileName);
            //fileContentsList = parser.splitResponse(allFileContents.get(fileName));
        }
        return fileContentsList;
    }

    private String getBestFit() {
        return "";
    }

    private void parseClass() throws IOException {
        for (int i = 0; i <= 5; i++) {
            //responseWordList.add(parser.splitResponse(responseList.get(i).getResponseText()));
        }

        findSimilarities(responseWordList, "class");
    }

    private void parseRace() throws IOException {
        for (int i = 6; i < 10; i++) {
            //responseWordList.add(parser.splitResponse(responseList.get(i).getResponseText()));
        }
        findSimilarities(responseWordList, "race");
    }

    private HashMap<String, String> processTextFile(String fileName) throws IOException {
        HashMap<String, String> fileContents = new HashMap<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String fileText = null;
        while (reader.readLine() != null) {
            fileText += reader.readLine();
            allFileContents.put(fileName, fileText);
        }

        reader.close();
        return allFileContents;
    }

}