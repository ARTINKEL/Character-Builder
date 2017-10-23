package edu.bsu.cs222;

import edu.bsu.cs222.model.ContentCreator;
import edu.bsu.cs222.model.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestContentCreator {

    @Test
    public void testCreateResponse() {
        ContentCreator contentCreator = new ContentCreator();
        String response = "I take out my sword and attack them.";
        Response responseObject = contentCreator.createResponse(response);
        Assert.assertEquals(responseObject.getResponse(), response);
    }

    @Test
    public void testGetFileContent() throws IOException {
        ContentCreator contentCreator = new ContentCreator();
        String fileName = "test.txt";
        String fileContent = contentCreator.getFileContent(fileName);
        Assert.assertEquals(fileContent, "nullThis is test content.");
    }
}
