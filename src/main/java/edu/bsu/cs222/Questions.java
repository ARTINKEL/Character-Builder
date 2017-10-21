package edu.bsu.cs222;

import java.util.HashMap;

public class Questions {

    HashMap<Integer, String> questionsMap = new HashMap<>();

    public Questions() {
        populateQuestions();
    }

    private void populateQuestions() {
        questionsMap.put(1, "How do you fight?");
        questionsMap.put(2, "What weapons, if any, do you use?");
        questionsMap.put(3, "How did you learn to fight?");
        questionsMap.put(4, "What armor, if any, do you wear?");
        questionsMap.put(5, "What do you think about religion?");
        questionsMap.put(6, "Where do you come from?");
        questionsMap.put(7, "How tall are you?");
        questionsMap.put(8, "Is your family magically inclined?");
        questionsMap.put(9, "How old are you?");
        questionsMap.put(10, "What is your hair color?");
    }

    public String getQuestion(int key) {
        return questionsMap.get(key);
    }
}