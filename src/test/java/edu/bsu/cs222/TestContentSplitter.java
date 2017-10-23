package edu.bsu.cs222;

import edu.bsu.cs222.model.ContentSplitter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestContentSplitter {

    @Test
    public void testSplitContentIntoWords() {
        ContentSplitter contentSplitter = new ContentSplitter();
        String sampleContent = "This is test content.";
        ArrayList<String> contentList = contentSplitter.splitContentIntoWords(sampleContent);
        Assert.assertEquals(contentList.get(0), "This");
    }
}
