package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestMapper {

    @Test
    public void testSplitResponse() {
        Response response = new Response("I am good.", "P");
        Mapper mapper = new Mapper();
        List<String> mapperResult = mapper.splitResponse(response);
        Assert.assertNotNull(mapperResult);
    }

    @Test
    public void testSplitResponse_GetFirstIndex() {
        Response response = new Response("I am good.", "P");
        Mapper mapper = new Mapper();
        List<String> mapperResult = mapper.splitResponse(response);
        Assert.assertEquals(mapperResult.get(0), "I");
    }
}
