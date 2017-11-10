package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.Keyword;
import edu.bsu.cs222.model.KeywordList;
import edu.bsu.cs222.model.KeywordParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKeywordParser {

    @Test
    public void testExtractKeywords() throws UnirestException {
        KeywordParser keywordParser = new KeywordParser();
        String text = "Test text.";

        KeywordList result = keywordParser.extractKeywords(text);

        ArrayList<Keyword> expected = new ArrayList<>();
        expected.add( new Keyword("test"));
        expected.add( new Keyword("text"));

        Assert.assertEquals(result.get(0).getKeyword(), expected.get(0).getKeyword());
    }

    @Test
    public void testExtractKeywords_DifferentData() throws UnirestException {
        KeywordParser keywordParser = new KeywordParser();
        String text = "I wade through the enemies, hacking at them with my sword, screaming in rage.";

        KeywordList result = keywordParser.extractKeywords(text);

        ArrayList<Keyword> expected = new ArrayList<>();
        expected.add( new Keyword("rage"));
        expected.add( new Keyword("hacking"));
        expected.add( new Keyword("wade"));
        expected.add( new Keyword("enemies"));
        expected.add( new Keyword("sword"));

        Assert.assertEquals(result.get(0).getKeyword(), expected.get(0).getKeyword());
    }

    // Learning test
    /*
    @Test
    public void testLearningKeyWordParser() throws UnirestException {
        KeywordParser keywordParser = new KeywordParser();
        String text = "Humming as she traces her fingers over an ancient monument in a long-forgotten ruin, a half-elf" +
                " in rugged leathers finds knowledge springing into her mind, conjured forth by the magic of her song, " +
                "knowledge of the people who constructed the monument and the mythic saga it depicts. A stern human " +
                "warrior bangs his sword rhythmically against his scale mail, setting the tempo for his war chant and " +
                "exhorting his companions to bravery and heroism. The magic of his song fortifies and emboldens them. " +
                "Laughing as she tunes her cittern, a gnome weaves her subtle magic over the assembled nobles, ensuring " +
                "that her companions' words will be well received. Whether scholar, skald, or scoundrel, a bard weaves " +
                "magic through words and music to inspire allies, demoralize foes, manipulate minds, create illusions, " +
                "and even heal wounds.";

        ArrayList<String> result = keywordParser.extractKeywords(text);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("test");
        expected.add("text");

        Assert.assertEquals(result, expected);
    }
    */
}
