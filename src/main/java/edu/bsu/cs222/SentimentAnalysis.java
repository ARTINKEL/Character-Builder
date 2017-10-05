package edu.bsu.cs222;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SentimentAnalysis {

    public void testSentimentAnalysis() throws UnirestException {

        String firstPart = "key=a532bb708c46f1448dff5d780930dbfd&lang=en&txt=";
        String secondPart = "&txtf=plain&of=json";
        String text = "Hello. Dick.";

        HttpResponse<JsonNode> response = Unirest.post("http://api.meaningcloud.com/sentiment-2.1")
                .header("content-type", "application/x-www-form-urlencoded")
                .body(firstPart + text + secondPart)
                .asJson();

        AnalyzerParser parser = new AnalyzerParser();
        //parser.parseStuff(response);
    }
}