package edu.bsu.cs222;

import edu.bsu.cs222.model.InputMap;
import edu.bsu.cs222.model.Response;
import org.junit.Assert;
import org.junit.Test;

public class TestInputMap {

    @Test
    public void testAddInput_NotNull() {
        InputMap inputMap = new InputMap();
        Response responseObject = new Response("This is test content.");
        inputMap.addInput(1, responseObject);
        Assert.assertNotNull(inputMap.getInputMap());
    }

    @Test
    public void testAddInput_AddContent() {
        InputMap inputMap = new InputMap();
        Response responseObject = new Response("This is test content.");
        inputMap.addInput(1, responseObject);
        Assert.assertEquals(inputMap.getInputMap().get(1).getResponse(), responseObject.getResponse());
    }

    @Test
    public void testRemoveInput() {
        InputMap inputMap = new InputMap();
        Response responseObject = new Response("This is test content.");
        inputMap.addInput(1, responseObject);
        inputMap.removeInput(1);
        Assert.assertNull(inputMap.getInputMap().get(1));
    }
}
