package edu.bsu.cs222.model;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.*;
import java.util.ArrayList;

public class DataGenerator {

    public ArrayList<String> raceFileNamesList = new ArrayList<String>() {
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

    public ArrayList<String> classFileNamesList = new ArrayList<String>() {
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

    public KeywordDictionary processClassFiles() throws UnirestException, IOException {
        KeywordDictionary classKeywordDictionary = new KeywordDictionary();

        for (String file : classFileNamesList) {
            classKeywordDictionary.add(generateKeywordsList(file));
        }
        return classKeywordDictionary;
    }

    public KeywordDictionary processRaceFiles() throws IOException, UnirestException {
        KeywordDictionary raceKeywordDictionary = new KeywordDictionary();

        for (String file : raceFileNamesList) {
            raceKeywordDictionary.add(generateKeywordsList(file));
        }
        return raceKeywordDictionary;
    }

    public KeywordList generateKeywordsList(String filename) throws IOException, UnirestException {
        KeywordExtractor keywordExtractor = new KeywordExtractor();
        String content = readFile(filename).toLowerCase();
        return keywordExtractor.extractKeywords(content);
    }

    private String readFile(String filename) throws IOException {
        InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        return reader.readLine();
    }
}