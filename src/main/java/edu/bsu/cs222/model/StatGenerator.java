package edu.bsu.cs222.model;

import java.util.HashMap;

public class StatGenerator {

    public HashMap<String, Integer> generateStandardArray(String className) {

        HashMap<String, Integer> abilityScores = new HashMap<>();

        switch (className) {
            case "Barbarian":
                abilityScores.put("Strength", 15);
                abilityScores.put("Dexterity", 13);
                abilityScores.put("Constitution", 14);
                abilityScores.put("Intelligence", 10);
                abilityScores.put("Wisdom", 8);
                abilityScores.put("Charisma", 12);
                break;
            case "Bard":
                abilityScores.put("Strength", 14);
                abilityScores.put("Dexterity", 13);
                abilityScores.put("Constitution", 8);
                abilityScores.put("Intelligence", 10);
                abilityScores.put("Wisdom", 12);
                abilityScores.put("Charisma", 15);
                break;
            case "Cleric":
                abilityScores.put("Strength", 13);
                abilityScores.put("Dexterity", 8);
                abilityScores.put("Constitution", 14);
                abilityScores.put("Intelligence", 10);
                abilityScores.put("Wisdom", 15);
                abilityScores.put("Charisma", 12);
                break;
            case "Druid":
                abilityScores.put("Strength", 13);
                abilityScores.put("Dexterity", 14);
                abilityScores.put("Constitution", 10);
                abilityScores.put("Intelligence", 12);
                abilityScores.put("Wisdom", 15);
                abilityScores.put("Charisma", 8);
                break;
            case "Fighter":
                abilityScores.put("Strength", 15);
                abilityScores.put("Dexterity", 13);
                abilityScores.put("Constitution", 14);
                abilityScores.put("Intelligence", 8);
                abilityScores.put("Wisdom", 12);
                abilityScores.put("Charisma", 10);
                break;
            case "Monk":
                abilityScores.put("Strength", 14);
                abilityScores.put("Dexterity", 15);
                abilityScores.put("Constitution", 12);
                abilityScores.put("Intelligence", 10);
                abilityScores.put("Wisdom", 13);
                abilityScores.put("Charisma", 8);
                break;
            case "Paladin":
                abilityScores.put("Strength", 15);
                abilityScores.put("Dexterity", 12);
                abilityScores.put("Constitution", 13);
                abilityScores.put("Intelligence", 8);
                abilityScores.put("Wisdom", 10);
                abilityScores.put("Charisma", 14);
                break;
            case "Ranger":
                abilityScores.put("Strength", 14);
                abilityScores.put("Dexterity", 15);
                abilityScores.put("Constitution", 10);
                abilityScores.put("Intelligence", 12);
                abilityScores.put("Wisdom", 13);
                abilityScores.put("Charisma", 8);
                break;
            case "Rogue":
                abilityScores.put("Strength", 12);
                abilityScores.put("Dexterity", 15);
                abilityScores.put("Constitution", 8);
                abilityScores.put("Intelligence", 13);
                abilityScores.put("Wisdom", 10);
                abilityScores.put("Charisma", 14);
                break;
            case "Sorcerer":
                abilityScores.put("Strength", 8);
                abilityScores.put("Dexterity", 14);
                abilityScores.put("Constitution", 12);
                abilityScores.put("Intelligence", 13);
                abilityScores.put("Wisdom", 10);
                abilityScores.put("Charisma", 15);
                break;
            case "Warlock":
                abilityScores.put("Strength", 14);
                abilityScores.put("Dexterity", 8);
                abilityScores.put("Constitution", 12);
                abilityScores.put("Intelligence", 10);
                abilityScores.put("Wisdom", 13);
                abilityScores.put("Charisma", 15);
                break;
            case "Wizard":
                abilityScores.put("Strength", 8);
                abilityScores.put("Dexterity", 12);
                abilityScores.put("Constitution", 13);
                abilityScores.put("Intelligence", 15);
                abilityScores.put("Wisdom", 14);
                abilityScores.put("Charisma", 10);
                break;
            default:
                abilityScores.put("Strength", 15);
                abilityScores.put("Dexterity", 14);
                abilityScores.put("Constitution", 13);
                abilityScores.put("Intelligence", 12);
                abilityScores.put("Wisdom", 10);
                abilityScores.put("Charisma", 8);
                break;
        }

        return abilityScores;
    }
}
