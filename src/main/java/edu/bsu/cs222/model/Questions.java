package edu.bsu.cs222.model;

import java.util.HashMap;

public class Questions {

    HashMap<Integer, String> questionsMap = new HashMap<>();

    public Questions() {
        populateQuestions();
    }

    private void populateQuestions() {
        questionsMap.put(1, "What weapons do you use in a fight?");
        questionsMap.put(2, "What kind of magic do you use?\n");
        questionsMap.put(3, "How do you fight?");
        questionsMap.put(4, "Describe how a typical battle that you are involved in would play out.");
        questionsMap.put(5, "What object has the most importance to you?");
        questionsMap.put(6, "How does your family make a living?");
        questionsMap.put(7, "Where does your family live?");
        questionsMap.put(8, "What is your heritage?");
        questionsMap.put(9, "Describe your personality.");
        questionsMap.put(10, "Describe your ideal retirement from adventuring.");
    }

    public String getQuestion(int key) {
        return questionsMap.get(key);
    }
}