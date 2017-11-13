package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.InputMap;
import edu.bsu.cs222.model.Mapper;
import edu.bsu.cs222.model.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestMapper {

    private InputMap getSampleInputMap() {
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

        return inputMap;
    }

    @Test
    public void testCalculateClassResult_NotNull() throws IOException, UnirestException {
        InputMap inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);
        String result = mapper.calculateClassResult();
        Assert.assertNotNull(result);
    }

    @Test
    public void testCompare() throws IOException, UnirestException {
        InputMap inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);


    }

    @Test
    public void testCalculateClassResult_Accuracy() throws IOException, UnirestException {
        InputMap inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);

    }

    @Test
    public void testCalculateRaceResult_NotNull() throws IOException, UnirestException {
        InputMap inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);
        String result = mapper.calculateRaceResult();
        Assert.assertNotNull(result);
    }

    @Test
    public void testCalculateRaceResult_Accuracy() throws IOException, UnirestException {
        InputMap inputMap = getSampleInputMap();
        Mapper mapper = new Mapper(inputMap);


    }
}