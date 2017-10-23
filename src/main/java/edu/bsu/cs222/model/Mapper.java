package edu.bsu.cs222.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mapper {

    private ArrayList<String> raceFileNamesList = new ArrayList<String>() {
        {
            add("Elf.txt");
            add("Dwarf.txt");
            add("Gnome.txt");
            add("Human.txt");
            add("Tiefling.txt");
            add("Dragonborn.txt");
            add("Halfling.txt");
            add("Half-Orc.txt");
            add("Half-Elf.txt");
        }
    };

    private ArrayList<String> classFileNamesList = new ArrayList<String>() {
        {
            add("Barbarian.txt");
            add("Bard.txt");
            add("Cleric.txt");
            add("Druid.txt");
            add("Fighter.txt");
            add("Monk.txt");
            add("Paladin.txt");
            add("Ranger.txt");
            add("Rogue.txt");
            add("Sorcerer.txt");
            add("Warlock.txt");
            add("Wizard.txt");
        }
    };

    private ContentSplitter contentSplitter = new ContentSplitter();
    private ContentCreator contentCreator = new ContentCreator();

    private ArrayList<Response> responsesList = new ArrayList<>();
    private ArrayList<ArrayList<String>> responseMasterList = new ArrayList<>();
    private ArrayList<ArrayList<String>> classContentMasterList = new ArrayList<>();
    private ArrayList<ArrayList<String>> raceContentMasterList = new ArrayList<>();

    private ArrayList<String> categoryFileNamesList = new ArrayList<>();
    private ArrayList<ArrayList<String>> categoryFileContentMasterList = new ArrayList<>();

    private HashMap<String, Integer> frequencyList = new HashMap<>();

    private InputMap inputMap = new InputMap();

    public Mapper(InputMap inputMap) throws IOException {
        this.inputMap = inputMap;
        createResponseObjectsList(inputMap);
        populateResponseMasterList();
        populateFileContentMasterList();
    }

    public ArrayList<Response> createResponseObjectsList(InputMap inputMap) {
        for (int i = 1; i <= inputMap.getInputMap().size(); i++) {
            responsesList.add(inputMap.getInputMap().get(i));
        }
        return responsesList;
    }

    private ArrayList<String> splitResponse(Response response) {
        return contentSplitter.splitContentIntoWords(response.getResponse());
    }

    private void populateResponseMasterList() {
        for (Response response : responsesList) {
            responseMasterList.add(splitResponse(response));
        }
    }

    private String getFileContent(String fileName) throws IOException {
        return contentCreator.getFileContent(fileName);
    }

    private ArrayList<String> splitFileContent(String fileContent) {
        return contentSplitter.splitContentIntoWords(fileContent);
    }

    private void populateFileContentMasterList() throws IOException {
        for (String fileName : classFileNamesList) {
            String fileContent = getFileContent(fileName);
            ArrayList<String> fileContentList = splitFileContent(fileContent);
            classContentMasterList.add(fileContentList);
        }

        for (String fileName : raceFileNamesList) {
            String fileContent = getFileContent(fileName);
            ArrayList<String> fileContestList = splitFileContent(fileContent);
            raceContentMasterList.add(fileContestList);
        }
    }

    public int compare(ArrayList<String> responseWordsList, ArrayList<String> fileWordsList) {
        int occurrences = 0;
        for (String word : responseWordsList) {
            if (fileWordsList.contains(word)) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public HashMap<String, Integer> getFrequency(String category) {
        int start = 0;
        int end = 0;
        if (category.equals("race")) {
            categoryFileNamesList = raceFileNamesList;
            categoryFileContentMasterList = raceContentMasterList;
            start = 0;
            end = 4;
        } else if (category.equals("class")) {
            categoryFileNamesList = classFileNamesList;
            categoryFileContentMasterList = classContentMasterList;
            start = 5;
            end = 9;
        }

        for (int i = start; i <= end; i++) {
            int index = 0;
            for (ArrayList<String> fileWords : categoryFileContentMasterList) {
                frequencyList.put(categoryFileNamesList.get(index), compare(responseMasterList.get(i), fileWords) );
                index++;
            }
        }
        return frequencyList;
    }

    private String calculateHighestFrequency(HashMap<String, Integer> resultMap) {
        Map.Entry<String, Integer> maxFrequency = null;

        for (Map.Entry<String, Integer> frequency : resultMap.entrySet()) {
            if (maxFrequency == null || frequency.getValue().compareTo(maxFrequency.getValue()) > 0) {
                maxFrequency = frequency;
            }
        }
        return maxFrequency.getKey();
    }

    public String calculateResult(String category) {
        String result = "";
        if (category.equals("race")) {
            HashMap<String, Integer> raceResultMap = getFrequency("race");
            result = calculateHighestFrequency(raceResultMap);
        } else if (category.equals("class")) {
            HashMap<String, Integer> classResultMap = getFrequency("class");
            result = calculateHighestFrequency(classResultMap);
        }
        return result;
    }
}