package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TestResponseProcessor {

    @Test
    public void testProcessClassResponseMap_NotNull() throws UnirestException {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        HashMap<Integer, Response> inputMap = new HashMap<>();

        inputMap.put(1, new Response("Sword"));
        inputMap.put(2, new Response("Sword"));
        inputMap.put(3, new Response("Sword"));
        inputMap.put(4, new Response("Sword"));
        inputMap.put(5, new Response("Sword"));
        inputMap.put(6, new Response("Sword"));
        inputMap.put(7, new Response("Sword"));
        inputMap.put(8, new Response("Sword"));
        inputMap.put(9, new Response("Sword"));
        inputMap.put(10, new Response("Sword"));

        KeywordLexicon responseKeywords = responseProcessor.processClassResponseMap(inputMap);
        Assert.assertNotNull(responseKeywords);
    }

    @Test
    public void testProcessClassResponseMap_Accuracy() throws UnirestException {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        HashMap<Integer, Response> inputMap = new HashMap<>();
        inputMap.put(1, new Response("Sword"));
        inputMap.put(2, new Response("Sword"));
        inputMap.put(3, new Response("Sword"));
        inputMap.put(4, new Response("Sword"));
        inputMap.put(5, new Response("Sword"));
        inputMap.put(6, new Response("Sword"));
        inputMap.put(7, new Response("Sword"));
        inputMap.put(8, new Response("Sword"));
        inputMap.put(9, new Response("Sword"));
        inputMap.put(10, new Response("Sword"));

        KeywordLexicon expected = new KeywordLexicon();
        KeywordList list1 = new KeywordList();
        list1.add(new Keyword("sword"));
        list1.add(new Keyword("fire"));
        expected.add(list1);
        KeywordList list2 = new KeywordList();
        list2.add(new Keyword("sword"));
        list2.add(new Keyword("fire"));
        expected.add(list2);

        KeywordLexicon actual = responseProcessor.processClassResponseMap(inputMap);

        Assert.assertEquals(expected.getKeywordList(0).get(0).getKeyword(), actual.getKeywordList(0).get(0).getKeyword());
    }

    @Test
    public void testProcessRaceResponseMap_NotNull() throws UnirestException {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        HashMap<Integer, Response> inputMap = new HashMap<>();
        inputMap.put(1, new Response("Sword"));
        inputMap.put(2, new Response("Sword"));
        inputMap.put(3, new Response("Sword"));
        inputMap.put(4, new Response("Sword"));
        inputMap.put(5, new Response("Sword"));
        inputMap.put(6, new Response("Sword"));
        inputMap.put(7, new Response("Sword"));
        inputMap.put(8, new Response("Sword"));
        inputMap.put(9, new Response("Sword"));
        inputMap.put(10, new Response("Sword"));

        KeywordLexicon responseKeywords = responseProcessor.processRaceResponseMap(inputMap);
        Assert.assertNotNull(responseKeywords);
    }

    @Test
    public void testProcessRaceResponseMap_Accuracy() throws UnirestException {
        ResponseProcessor responseProcessor = new ResponseProcessor();

        HashMap<Integer, Response> inputMap = new HashMap<>();
        inputMap.put(1, new Response("Sword"));
        inputMap.put(2, new Response("Sword"));
        inputMap.put(3, new Response("Sword"));
        inputMap.put(4, new Response("Sword"));
        inputMap.put(5, new Response("Sword"));
        inputMap.put(6, new Response("Sword"));
        inputMap.put(7, new Response("Sword"));
        inputMap.put(8, new Response("Sword"));
        inputMap.put(9, new Response("Sword"));
        inputMap.put(10, new Response("Sword"));

        KeywordLexicon expected = new KeywordLexicon();
        KeywordList list1 = new KeywordList();
        list1.add(new Keyword("sword"));
        list1.add(new Keyword("fire"));
        expected.add(list1);
        KeywordList list2 = new KeywordList();
        list2.add(new Keyword("sword"));
        list2.add(new Keyword("fire"));
        expected.add(list2);

        KeywordLexicon actual = responseProcessor.processRaceResponseMap(inputMap);

        Assert.assertEquals(expected.getKeywordList(0).get(0).getKeyword(), actual.getKeywordList(0).get(0).getKeyword());
    }
}