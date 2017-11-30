package edu.bsu.cs222.model;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;

public class ResponseProcessor {

    private final int classBeginningIndex = 1;
    private final int classEndingIndex = 6;
    private final int raceEndingIndex = 10;

    private KeywordExtractor keywordExtractor = new KeywordExtractor();

    public KeywordDictionary processClassResponseMap(HashMap<Integer, Response> inputMap) throws UnirestException {

        KeywordDictionary classResponses = new KeywordDictionary();

        for (int i = classBeginningIndex; i < classEndingIndex; i++) {
            KeywordList keywordList = keywordExtractor.extractKeywords(inputMap.get(i).getResponse());
            classResponses.add(keywordList);
        }
        return classResponses;
    }

    public KeywordDictionary processRaceResponseMap(HashMap<Integer, Response> inputMap) throws UnirestException {
        KeywordDictionary raceResponses = new KeywordDictionary();

        for (int i = classEndingIndex; i < raceEndingIndex; i++) {
            KeywordList keywordList = keywordExtractor.extractKeywords(inputMap.get(i).getResponse());
            raceResponses.add(keywordList);
        }
        return raceResponses;
    }
}