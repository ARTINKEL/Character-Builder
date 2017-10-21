package edu.bsu.cs222;

import edu.bsu.cs222.model.Questions;
import org.junit.Assert;
import org.junit.Test;

public class TestQuestions {
    @Test
    public void testGetQuestions() {
        Questions questions = new Questions();
        String question = questions.getQuestion(1);
        Assert.assertEquals(question, "How do you fight?");
    }
}
