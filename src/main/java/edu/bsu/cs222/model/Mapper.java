package edu.bsu.cs222.model;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Mapper {

    private DataGenerator dataGenerator = new DataGenerator();
    private KeywordDictionary classFileKeywords = new KeywordDictionary();
    private KeywordDictionary raceFileKeywords = new KeywordDictionary();

    public Mapper() throws IOException, UnirestException {
        populateFileDictionaries();
    }

    private void populateFileDictionaries() throws IOException, UnirestException {
        classFileKeywords = dataGenerator.processClassFiles();
        raceFileKeywords = dataGenerator.processRaceFiles();
    }

    public String calculateRaceResult() {
        return null;
    }

    public String calculateClassResult() {
        return null;
    }
}