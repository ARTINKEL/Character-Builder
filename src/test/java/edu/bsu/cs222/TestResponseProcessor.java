package edu.bsu.cs222;

import edu.bsu.cs222.model.*;
import org.junit.Assert;
import org.junit.Test;

public class TestResponseProcessor {

    @Test
    public void testProcessResponseMap_NotNull() {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        InputMap inputMap = new InputMap();
        inputMap.addInput(1, new Response("Sword"));
        inputMap.addInput(2, new Response("Sword"));

        KeywordDictionary responseKeywords = responseProcessor.processResponseMap(inputMap);
        Assert.assertNotNull(responseKeywords);
    }

    @Test
    public void testProcessResponseMap_Accuracy() {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        InputMap inputMap = new InputMap();
        inputMap.addInput(1, new Response("Fire Sword"));
        inputMap.addInput(2, new Response("Fire Sword"));

        KeywordDictionary expected = new KeywordDictionary();
        KeywordList list1 = new KeywordList();
        list1.add(new Keyword("Fire"));
        list1.add(new Keyword("Sword"));
        expected.add(list1);
        KeywordList list2 = new KeywordList();
        list2.add(new Keyword("Fire"));
        list2.add(new Keyword("Sword"));
        expected.add(list2);

        KeywordDictionary actual = responseProcessor.processResponseMap(inputMap);

        Assert.assertEquals(actual, expected);
    }
}
