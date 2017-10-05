package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {

    public static void main(String[] args) throws UnirestException {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        sentimentAnalysis.testSentimentAnalysis();
    }
}
