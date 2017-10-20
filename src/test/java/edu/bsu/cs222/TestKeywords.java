package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

public class TestKeywords {

    @Test
    public void testBardEnum_Name() {
        String value = Keywords.BARD_KEYWORDS.Bard.getName();
        Assert.assertEquals(value, "Bard");
    }

    @Test
    public void testBardEnum_Weight() {
        int value = Keywords.BARD_KEYWORDS.Bard.getWeight();
        Assert.assertEquals(value, 20);
    }
}
