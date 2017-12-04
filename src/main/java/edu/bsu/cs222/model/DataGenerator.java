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

    public KeywordLexicon processClassFiles() throws UnirestException, IOException {
        KeywordLexicon classKeywordLexicon = new KeywordLexicon();

        for (String file : classFileNamesList) {
            classKeywordLexicon.add(generateKeywordsList(file));
        }
        return classKeywordLexicon;
    }

    public KeywordLexicon processRaceFiles() throws IOException, UnirestException {
        KeywordLexicon raceKeywordLexicon = new KeywordLexicon();

        for (String file : raceFileNamesList) {
            raceKeywordLexicon.add(generateKeywordsList(file));
        }
        return raceKeywordLexicon;
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