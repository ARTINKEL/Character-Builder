package edu.bsu.cs222;

import edu.bsu.cs222.model.Response;
import org.junit.Assert;
import org.junit.Test;

public class TestResponse {

    @Test
    public void testGetResponse() {
        Response testResponse = new Response("This is test content.");
        Assert.assertEquals(testResponse.getResponse(), "This is test content.");
    }
}