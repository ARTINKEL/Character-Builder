package edu.bsu.cs222.model;

import java.util.ArrayList;

public class ContentSplitter {
    public ArrayList<String> splitContentIntoWords(String content) {
        ArrayList<String> wordList = new ArrayList<>();
        String[] array = content.split(" ");
        for (String i : array) {
            wordList.add(i);
        }
        return wordList;
    }
}