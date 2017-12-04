package edu.bsu.cs222.model;

import java.util.ArrayList;

public class KeywordList {

    private final ArrayList<Keyword> keywordList = new ArrayList<>();

    public void add(Keyword keyword) {
        keywordList.add(keyword);
    }

    public Keyword get(int i) {
        return keywordList.get(i);
    }

    public int size() { return keywordList.size(); }
}