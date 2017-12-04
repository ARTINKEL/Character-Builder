package edu.bsu.cs222.model;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Mapper {
    private DataGenerator dataGenerator = new DataGenerator();
    private ResponseProcessor responseProcessor = new ResponseProcessor();

    private KeywordLexicon classFileKeywords = new KeywordLexicon();
    private KeywordLexicon raceFileKeywords = new KeywordLexicon();
    private KeywordLexicon classResponseKeywords = new KeywordLexicon();
    private KeywordLexicon raceResponseKeywords = new KeywordLexicon();

    public Mapper(HashMap<Integer, Response> inputMap) throws IOException, UnirestException {
        populateFileDictionaries();
        classResponseKeywords = responseProcessor.processClassResponseMap(inputMap);
        raceResponseKeywords = responseProcessor.processRaceResponseMap(inputMap);
    }

    private void populateFileDictionaries() throws IOException, UnirestException {
        classFileKeywords = dataGenerator.processClassFiles();
        raceFileKeywords = dataGenerator.processRaceFiles();
    }

    public int compareKeywords(KeywordList fileKeywords, KeywordList responseKeywords) {
        int occurrences = 0;
        for (int i = 0; i < responseKeywords.size(); i++) {
            for (int j = 0; j < fileKeywords.size(); j++) {
                String responseKeyword = responseKeywords.get(i).getKeyword();
                String fileKeyword = fileKeywords.get(j).getKeyword();
                if (fileKeyword.contains(responseKeyword)) {
                    occurrences++;
                }
            }
        }
        return occurrences;
    }

    public String calculateRaceResult() {
        ArrayList<Integer> occurrences = new ArrayList<>();

        for (int i = 0; i < raceResponseKeywords.size(); i++) {
            for (int j = 0; j < raceFileKeywords.size(); j++) {
                occurrences.add(compareKeywords(raceFileKeywords.getKeywordList(j), raceResponseKeywords.getKeywordList(i)));
            }
        }
        return calculateGreatestFrequency(occurrences, dataGenerator.raceFileNamesList);
    }

    public String calculateClassResult() {
        ArrayList<Integer> occurrences = new ArrayList<>();

        for (int i = 0; i < classResponseKeywords.size(); i++) {
            for (int j = 0; j < classFileKeywords.size(); j++) {
                occurrences.add(compareKeywords(classFileKeywords.getKeywordList(j), classResponseKeywords.getKeywordList(i)));
            }
        }
        return calculateGreatestFrequency(occurrences, dataGenerator.classFileNamesList);
    }

    private String calculateGreatestFrequency(ArrayList<Integer> occurrences, ArrayList<String> fileNamesList) {
        int largest = 0;
        int index = 0;
        int finalIndex = 0;
        for (int number : occurrences) {
            if (number > largest) {
                largest = number;
                finalIndex = index;
            }
            index++;
        }
        String fileName = fileNamesList.get(finalIndex);
        return fileName.substring(0, fileName.length() - 4);
    }
}