package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.DataGenerator;
import edu.bsu.cs222.model.Keyword;
import edu.bsu.cs222.model.KeywordLexicon;
import edu.bsu.cs222.model.KeywordList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class TestDataGenerator {

    @Test
    public void testGenerateClassKeywords() throws IOException, UnirestException {
        DataGenerator dataGenerator = new DataGenerator();
        KeywordList keywords = dataGenerator.generateKeywordsList("test.txt");
        KeywordList expected = new KeywordList();
        expected.add( new Keyword("test"));
        Assert.assertEquals(expected.get(0).getKeyword(), keywords.get(0).getKeyword());
    }
}