package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

public class TestResponse {

    @Test
    public void testResponseObject() {
        Response response = new Response("Hello", "NONE");
        Assert.assertNotNull(response);
    }

    @Test
    public void testGetResponseText() {
        Response response = new Response("Hello", "NONE");
        Assert.assertEquals(response.getResponseText(), "Hello");
    }

    @Test
    public void testGetSentimentResponse() {
        Response response = new Response("Hello", "NONE");
        Assert.assertEquals(response.getSentimentResponse(), "NONE");
    }
}
