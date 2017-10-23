package edu.bsu.cs222.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SentimentAnalysisParser {

    private final static int NUMBER_OF_QUESTIONS = 10;
    private SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
    private ArrayList<Response> responseList = new ArrayList<>();

    public void createResponseObjects(HashMap<Integer, String> inputMap) throws UnirestException {
        for (int i = 1; i <= inputMap.size(); i++) {

            /*
                DON'T FORGET TO CHANGE, DAMMIT
                useSentimentAnalysis(inputMap.get(i))
             */

            Response response = new Response(inputMap.get(i), "");
            responseList.add(response);
        }
    }

    private String useSentimentAnalysis(String input) throws UnirestException {
        HttpResponse httpResponse = sentimentAnalysis.requestResponse(input);
        return parseResponse(httpResponse.getRawBody());
    }

    public ArrayList<Response> getResponseList() {
        return responseList;
    }

    public String parseResponse(InputStream inputStream) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject jsonObject = rootElement.getAsJsonObject();
        return jsonObject.get("score_tag").toString();
    }
}