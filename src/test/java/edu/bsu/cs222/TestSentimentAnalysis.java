package edu.bsu.cs222;

import com.google.gson.JsonElement;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.SentimentAnalysis;
import org.junit.Assert;
import org.junit.Test;

public class TestSentimentAnalysis {

    @Test
    public void testGetSentiment() throws UnirestException {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        String text = "I hate dwarves.";
        String actual = sentimentAnalysis.getSentiment(text);
        String expected = "N";
        Assert.assertEquals(expected, actual);
    }
}
