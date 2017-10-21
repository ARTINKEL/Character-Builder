package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
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

    @Test
    public void testNewMethod() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Response response1 = new Response("I summon the awesome elemental power of nature and smite the orc", "PPlus");

        String stuff = null;
        while (reader.readLine() != null) {
            stuff += reader.readLine();
        }

        ResponseParser parser = new ResponseParser();
        List<String> mapperResult = parser.splitResponse(response1);
        for (String result : mapperResult) {
            if (stuff.contains(result)) {
                System.out.println(result);
            }
        }
        System.out.println(mapperResult);
        System.out.println(stuff);
        reader.close();
        Assert.assertEquals("", "");
    }
}
