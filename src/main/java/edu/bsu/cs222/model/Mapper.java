package edu.bsu.cs222.model;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Mapper {

    private DataGenerator dataGenerator = new DataGenerator();

    public Mapper() throws IOException, UnirestException {
        dataGenerator.processClassFiles();
        dataGenerator.processRaceFiles();
    }

    public String calculateRaceResult() {
        return null;
    }

    public String calculateClassResult() {
        return null;
    }
}