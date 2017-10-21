package edu.bsu.cs222;

import edu.bsu.cs222.model.Response;
import edu.bsu.cs222.model.ResponseParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestResponseParser {

    @Test
    public void testSplitResponse() {
        Response response = new Response("I am good.", "P");
        ResponseParser responseParser = new ResponseParser();
        List<String> mapperResult = responseParser.splitResponse(response);
        Assert.assertNotNull(mapperResult);
    }

    @Test
    public void testSplitResponse_GetFirstIndex() {
        Response response = new Response("I am good.", "P");
        ResponseParser responseParser = new ResponseParser();
        List<String> mapperResult = responseParser.splitResponse(response);
        Assert.assertEquals(mapperResult.get(0), "I");
    }
}
