package edu.bsu.cs222.model;

import java.util.HashMap;

public class InputMap {

    private HashMap<Integer, Response> inputMap = new HashMap<>();

    public void addInput(int questionNumber, Response response) {
        inputMap.put(questionNumber, response);
    }

    public void removeInput(int questionNumber) {
        inputMap.remove(questionNumber);
    }

    public HashMap<Integer, Response> getInputMap() {
        return inputMap;
    }
}