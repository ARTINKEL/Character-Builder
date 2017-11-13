package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.DataGenerator;
import edu.bsu.cs222.model.Keyword;
import edu.bsu.cs222.model.KeywordDictionary;
import edu.bsu.cs222.model.KeywordList;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TestDataGenerator {

    @Test
    public void testGenerateClassKeywords() throws IOException, UnirestException {
        DataGenerator dataGenerator = new DataGenerator();

        KeywordList keywords = dataGenerator.generateKeywordsList("test.txt");

        KeywordList expected = new KeywordList();
        expected.add( new Keyword("test"));
        expected.add( new Keyword("test"));
        expected.add( new Keyword("test"));

        Assert.assertEquals(expected.get(0).getKeyword(), keywords.get(0).getKeyword());
    }

    @Test
    public void testProcessClassFiles() throws IOException, UnirestException {
        DataGenerator dataGenerator = new DataGenerator();
        KeywordDictionary actual = dataGenerator.processClassFiles();
        Assert.assertNotNull(actual);
    }

    @Test
    public void testProcessRaceFiles() throws IOException, UnirestException {
        DataGenerator dataGenerator = new DataGenerator();
        KeywordDictionary actual = dataGenerator.processRaceFiles();
        Assert.assertNotNull(actual);
    }
}