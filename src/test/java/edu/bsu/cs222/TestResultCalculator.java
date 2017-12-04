package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class TestResultCalculator {

    private HashMap<Integer, Response> getSampleInputMap() {
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
        return inputMap;
    }

    @Test
    public void testCompare() throws IOException, UnirestException {
        HashMap<Integer, Response> inputMap = getSampleInputMap();
        ResultCalculator resultCalculator = new ResultCalculator(inputMap);
        KeywordList list1 = new KeywordList();
        list1.add(new Keyword("sword"));
        list1.add(new Keyword("fire"));
        KeywordList list2 = new KeywordList();
        list2.add(new Keyword("sword"));
        list2.add(new Keyword("fire"));
        int actual = resultCalculator.compareKeywords(list1, list2);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateClassResult_Accuracy() throws IOException, UnirestException {
        HashMap<Integer, Response> inputMap = getSampleInputMap();
        ResultCalculator resultCalculator = new ResultCalculator(inputMap);
        Assert.assertEquals("Fighter", resultCalculator.calculateClassResult());
    }

    @Test
    public void testCalculateRaceResult_Accuracy() throws IOException, UnirestException {
        HashMap<Integer, Response> inputMap = getSampleInputMap();
        ResultCalculator resultCalculator = new ResultCalculator(inputMap);
        Assert.assertEquals("Elf", resultCalculator.calculateRaceResult());
    }
}