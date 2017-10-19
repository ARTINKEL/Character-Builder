package edu.bsu.cs222;

import com.google.gson.JsonElement;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class TestSentimentAnalysis {

    @Test
    public void testRequestResponse() throws UnirestException {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        HttpResponse jsonResponse = sentimentAnalysis.requestResponse("I am a dwarf paladin");
        Assert.assertNotNull(jsonResponse.getRawBody());
    }

    @Test
    public void testAnalyzerParser() throws UnirestException{
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        AnalyzerParser parser = new AnalyzerParser();
        HttpResponse jsonResponse = sentimentAnalysis.requestResponse("I am a human");
        String response = parser.parseResponse(jsonResponse.getRawBody());
        Assert.assertNotNull(response);
    }

    @Test
    public void testAnalyzerParser_() {

    }
}