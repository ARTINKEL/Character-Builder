package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class TestMapper {

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
    public void testCalculateClassResult_NotNull() throws IOException, UnirestException {
        HashMap<Integer, Response> inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);
        String result = mapper.calculateClassResult();
        Assert.assertNotNull(result);
    }

    @Test
    public void testCompare() throws IOException, UnirestException {
        HashMap<Integer, Response> inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);

        KeywordList list1 = new KeywordList();
        list1.add(new Keyword("sword"));
        list1.add(new Keyword("fire"));

        KeywordList list2 = new KeywordList();
        list2.add(new Keyword("sword"));
        list2.add(new Keyword("fire"));

        int actual = mapper.compareKeywords(list1, list2);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateClassResult_Default() throws IOException, UnirestException {
        HashMap<Integer, Response> inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);
        //Expected here is Bard because that is the default result if no user input is collected
        String expected = "Bard";
        Assert.assertEquals(expected, mapper.calculateClassResult());
    }

    @Test
    public void testCalculateRaceResult_NotNull() throws IOException, UnirestException {
        HashMap<Integer, Response> inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);
        String result = mapper.calculateRaceResult();
        Assert.assertNotNull(result);
    }

    @Test
    public void testCalculateRaceResult_Default() throws IOException, UnirestException {
        HashMap<Integer, Response> inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);
        //Expected is Elf because that is the default value for Race if there is no user input
        String expected = "Elf";
        Assert.assertEquals(expected, mapper.calculateRaceResult());
    }
}