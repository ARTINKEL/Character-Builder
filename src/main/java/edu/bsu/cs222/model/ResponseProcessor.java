package edu.bsu.cs222.model;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;

public class ResponseProcessor {

    private KeywordParser keywordParser = new KeywordParser();

    public KeywordDictionary processClassResponseMap(InputMap inputMap) throws UnirestException {

        KeywordDictionary classResponses = new KeywordDictionary();

        HashMap<Integer, Response> map = inputMap.getInputMap();

        for (int i = 1; i < 6; i++) {
            KeywordList keywordList = keywordParser.extractKeywords(map.get(i).getResponse());
            classResponses.add(keywordList);
        }
        return classResponses;
    }

    public KeywordDictionary processRaceResponseMap(InputMap inputMap) throws UnirestException {
        KeywordDictionary raceResponses = new KeywordDictionary();

        HashMap<Integer, Response> map = inputMap.getInputMap();

        for (int i = 6; i < 10; i++) {
            KeywordList keywordList = keywordParser.extractKeywords(map.get(i).getResponse());
            raceResponses.add(keywordList);
        }
        return raceResponses;
    }
}