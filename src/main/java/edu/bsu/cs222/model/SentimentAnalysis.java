package edu.bsu.cs222.model;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SentimentAnalysis {

    public HttpResponse requestResponse(String text) throws UnirestException {
        String firstPart = "key=a532bb708c46f1448dff5d780930dbfd&lang=en&txt=";
        String secondPart = "&txtf=plain&of=json";

        return Unirest.post("http://api.meaningcloud.com/sentiment-2.1")
                .header("content-type", "application/x-www-form-urlencoded")
                .body(firstPart + text + secondPart)
                .asJson();
    }
}