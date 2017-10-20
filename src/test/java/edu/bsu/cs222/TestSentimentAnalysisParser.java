package edu.bsu.cs222;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class TestSentimentAnalysisParser {

    @Test
    public void testResponseParser() throws UnirestException{
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        SentimentAnalysisParser parser = new SentimentAnalysisParser();
        HttpResponse jsonResponse = sentimentAnalysis.requestResponse("I am a human");
        String response = parser.parseResponse(jsonResponse.getRawBody());
        Assert.assertNotNull(response);
    }
}
