package edu.bsu.cs222.model;

import java.util.ArrayList;

public class KeywordLexicon {

    private ArrayList<KeywordList> arrayOfFileKeywords = new ArrayList<>();

    public KeywordList getKeywordList(int i) {
        return arrayOfFileKeywords.get(i);
    }

    public void add(KeywordList list) {
        arrayOfFileKeywords.add(list);
    }

    public int size() {
        return arrayOfFileKeywords.size();
    }
}