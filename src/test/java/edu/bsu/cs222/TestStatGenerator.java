package edu.bsu.cs222;

import edu.bsu.cs222.model.StatGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TestStatGenerator {

    @Test
    public void testGenerateStandardArray_Barbarian() {
        StatGenerator statGenerator = new StatGenerator();
        HashMap<String, Integer> actual = statGenerator.generateStandardArray("Barbarian");
        int expectedStrength = 15;
        Assert.assertEquals(expectedStrength, (int) actual.get("Strength"));
    }

    @Test
    public void testGenerateStandardArray_Monk() {
        StatGenerator statGenerator = new StatGenerator();
        HashMap<String, Integer> actual = statGenerator.generateStandardArray("Monk");
        int expectedStrength = 15;
        Assert.assertEquals(expectedStrength, (int) actual.get("Dexterity"));
    }
}
