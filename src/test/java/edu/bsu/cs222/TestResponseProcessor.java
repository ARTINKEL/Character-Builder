package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.*;
import org.junit.Assert;
import org.junit.Test;

public class TestResponseProcessor {

    @Test
    public void testProcessClassResponseMap_NotNull() throws UnirestException {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        InputMap inputMap = new InputMap();

        inputMap.addInput(1, new Response("Sword"));
        inputMap.addInput(2, new Response("Sword"));
        inputMap.addInput(3, new Response("Sword"));
        inputMap.addInput(4, new Response("Sword"));
        inputMap.addInput(5, new Response("Sword"));
        inputMap.addInput(6, new Response("Sword"));
        inputMap.addInput(7, new Response("Sword"));
        inputMap.addInput(8, new Response("Sword"));
        inputMap.addInput(9, new Response("Sword"));
        inputMap.addInput(10, new Response("Sword"));

        KeywordDictionary responseKeywords = responseProcessor.processClassResponseMap(inputMap);
        Assert.assertNotNull(responseKeywords);
    }

    @Test
    public void testProcessClassResponseMap_Accuracy() throws UnirestException {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        InputMap inputMap = new InputMap();
        inputMap.addInput(1, new Response("Sword"));
        inputMap.addInput(2, new Response("Sword"));
        inputMap.addInput(3, new Response("Sword"));
        inputMap.addInput(4, new Response("Sword"));
        inputMap.addInput(5, new Response("Sword"));
        inputMap.addInput(6, new Response("Sword"));
        inputMap.addInput(7, new Response("Sword"));
        inputMap.addInput(8, new Response("Sword"));
        inputMap.addInput(9, new Response("Sword"));
        inputMap.addInput(10, new Response("Sword"));

        KeywordDictionary expected = new KeywordDictionary();
        KeywordList list1 = new KeywordList();
        list1.add(new Keyword("sword"));
        list1.add(new Keyword("fire"));
        expected.add(list1);
        KeywordList list2 = new KeywordList();
        list2.add(new Keyword("sword"));
        list2.add(new Keyword("fire"));
        expected.add(list2);

        KeywordDictionary actual = responseProcessor.processClassResponseMap(inputMap);

        Assert.assertEquals(actual.getKeywordList(0).get(0).getKeyword(), expected.getKeywordList(0).get(0).getKeyword());
    }

    @Test
    public void testProcessRaceResponseMap_NotNull() throws UnirestException {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        InputMap inputMap = new InputMap();
        inputMap.addInput(1, new Response("Sword"));
        inputMap.addInput(2, new Response("Sword"));
        inputMap.addInput(3, new Response("Sword"));
        inputMap.addInput(4, new Response("Sword"));
        inputMap.addInput(5, new Response("Sword"));
        inputMap.addInput(6, new Response("Sword"));
        inputMap.addInput(7, new Response("Sword"));
        inputMap.addInput(8, new Response("Sword"));
        inputMap.addInput(9, new Response("Sword"));
        inputMap.addInput(10, new Response("Sword"));

        KeywordDictionary responseKeywords = responseProcessor.processRaceResponseMap(inputMap);
        Assert.assertNotNull(responseKeywords);
    }

    @Test
    public void testProcessRaceResponseMap_Accuracy() throws UnirestException {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        InputMap inputMap = new InputMap();
        inputMap.addInput(1, new Response("Sword"));
        inputMap.addInput(2, new Response("Sword"));
        inputMap.addInput(3, new Response("Sword"));
        inputMap.addInput(4, new Response("Sword"));
        inputMap.addInput(5, new Response("Sword"));
        inputMap.addInput(6, new Response("Sword"));
        inputMap.addInput(7, new Response("Sword"));
        inputMap.addInput(8, new Response("Sword"));
        inputMap.addInput(9, new Response("Sword"));
        inputMap.addInput(10, new Response("Sword"));

        KeywordDictionary expected = new KeywordDictionary();
        KeywordList list1 = new KeywordList();
        list1.add(new Keyword("sword"));
        list1.add(new Keyword("fire"));
        expected.add(list1);
        KeywordList list2 = new KeywordList();
        list2.add(new Keyword("sword"));
        list2.add(new Keyword("fire"));
        expected.add(list2);

        KeywordDictionary actual = responseProcessor.processRaceResponseMap(inputMap);

        Assert.assertEquals(actual.getKeywordList(0).get(0).getKeyword(), expected.getKeywordList(0).get(0).getKeyword());
    }
}