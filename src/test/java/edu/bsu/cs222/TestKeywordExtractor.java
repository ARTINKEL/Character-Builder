package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.Keyword;
import edu.bsu.cs222.model.KeywordList;
import edu.bsu.cs222.model.KeywordExtractor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKeywordExtractor {

    @Test
    public void testExtractKeywords() throws UnirestException {
        KeywordExtractor keywordExtractor = new KeywordExtractor();
        String text = "Test text.";

        KeywordList result = keywordExtractor.extractKeywords(text);

        ArrayList<Keyword> expected = new ArrayList<>();
        expected.add( new Keyword("test"));
        expected.add( new Keyword("text"));

        Assert.assertEquals(result.get(0).getKeyword(), expected.get(0).getKeyword());
    }

    @Test
    public void testExtractKeywords_DifferentData() throws UnirestException {
        KeywordExtractor keywordExtractor = new KeywordExtractor();
        String text = "I wade through the enemies, hacking at them with my sword, screaming in rage.";

        KeywordList result = keywordExtractor.extractKeywords(text);

        ArrayList<Keyword> expected = new ArrayList<>();
        expected.add( new Keyword("rage"));
        expected.add( new Keyword("hacking"));
        expected.add( new Keyword("wade"));
        expected.add( new Keyword("enemies"));
        expected.add( new Keyword("sword"));

        Assert.assertEquals(result.get(0).getKeyword(), expected.get(0).getKeyword());
    }
}
