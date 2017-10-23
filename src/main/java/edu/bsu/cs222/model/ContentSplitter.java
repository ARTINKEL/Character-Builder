package edu.bsu.cs222.model;

import java.util.ArrayList;
import java.util.Collections;

public class ContentSplitter {
    public ArrayList<String> splitContentIntoWords(String content) {
        ArrayList<String> wordList = new ArrayList<>();
        String[] array = content.split(" ");
        Collections.addAll(wordList, array);
        return wordList;
    }
}