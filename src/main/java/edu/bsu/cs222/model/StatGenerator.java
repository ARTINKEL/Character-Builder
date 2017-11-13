package edu.bsu.cs222.model;

import java.util.HashMap;

public class StatGenerator {

    public HashMap<String, Integer> generateStandardArray(String className) {

        HashMap<String, Integer> standardAbilityScores = new HashMap<>();

        switch (className) {
            case "Barbarian":
                standardAbilityScores.put("Strength", 15);
                standardAbilityScores.put("Dexterity", 13);
                standardAbilityScores.put("Constitution", 14);
                standardAbilityScores.put("Intelligence", 10);
                standardAbilityScores.put("Wisdom", 8);
                standardAbilityScores.put("Charisma", 12);
                break;
            case "Bard":
                standardAbilityScores.put("Strength", 14);
                standardAbilityScores.put("Dexterity", 13);
                standardAbilityScores.put("Constitution", 8);
                standardAbilityScores.put("Intelligence", 10);
                standardAbilityScores.put("Wisdom", 12);
                standardAbilityScores.put("Charisma", 15);
                break;
            case "Cleric":
                standardAbilityScores.put("Strength", 13);
                standardAbilityScores.put("Dexterity", 8);
                standardAbilityScores.put("Constitution", 14);
                standardAbilityScores.put("Intelligence", 10);
                standardAbilityScores.put("Wisdom", 15);
                standardAbilityScores.put("Charisma", 12);
                break;
            case "Druid":
                standardAbilityScores.put("Strength", 13);
                standardAbilityScores.put("Dexterity", 14);
                standardAbilityScores.put("Constitution", 10);
                standardAbilityScores.put("Intelligence", 12);
                standardAbilityScores.put("Wisdom", 15);
                standardAbilityScores.put("Charisma", 8);
                break;
            case "Fighter":
                standardAbilityScores.put("Strength", 15);
                standardAbilityScores.put("Dexterity", 13);
                standardAbilityScores.put("Constitution", 14);
                standardAbilityScores.put("Intelligence", 8);
                standardAbilityScores.put("Wisdom", 12);
                standardAbilityScores.put("Charisma", 10);
                break;
            case "Monk":
                standardAbilityScores.put("Strength", 14);
                standardAbilityScores.put("Dexterity", 15);
                standardAbilityScores.put("Constitution", 12);
                standardAbilityScores.put("Intelligence", 10);
                standardAbilityScores.put("Wisdom", 13);
                standardAbilityScores.put("Charisma", 8);
                break;
            case "Paladin":
                standardAbilityScores.put("Strength", 15);
                standardAbilityScores.put("Dexterity", 12);
                standardAbilityScores.put("Constitution", 13);
                standardAbilityScores.put("Intelligence", 8);
                standardAbilityScores.put("Wisdom", 10);
                standardAbilityScores.put("Charisma", 14);
                break;
            case "Ranger":
                standardAbilityScores.put("Strength", 14);
                standardAbilityScores.put("Dexterity", 15);
                standardAbilityScores.put("Constitution", 10);
                standardAbilityScores.put("Intelligence", 12);
                standardAbilityScores.put("Wisdom", 13);
                standardAbilityScores.put("Charisma", 8);
                break;
            case "Rogue":
                standardAbilityScores.put("Strength", 12);
                standardAbilityScores.put("Dexterity", 15);
                standardAbilityScores.put("Constitution", 8);
                standardAbilityScores.put("Intelligence", 13);
                standardAbilityScores.put("Wisdom", 10);
                standardAbilityScores.put("Charisma", 14);
                break;
            case "Sorcerer":
                standardAbilityScores.put("Strength", 8);
                standardAbilityScores.put("Dexterity", 14);
                standardAbilityScores.put("Constitution", 12);
                standardAbilityScores.put("Intelligence", 13);
                standardAbilityScores.put("Wisdom", 10);
                standardAbilityScores.put("Charisma", 15);
                break;
            case "Warlock":
                standardAbilityScores.put("Strength", 14);
                standardAbilityScores.put("Dexterity", 8);
                standardAbilityScores.put("Constitution", 12);
                standardAbilityScores.put("Intelligence", 10);
                standardAbilityScores.put("Wisdom", 13);
                standardAbilityScores.put("Charisma", 15);
                break;
            case "Wizard":
                standardAbilityScores.put("Strength", 8);
                standardAbilityScores.put("Dexterity", 12);
                standardAbilityScores.put("Constitution", 13);
                standardAbilityScores.put("Intelligence", 15);
                standardAbilityScores.put("Wisdom", 14);
                standardAbilityScores.put("Charisma", 10);
                break;
            default:
                standardAbilityScores.put("Strength", 15);
                standardAbilityScores.put("Dexterity", 14);
                standardAbilityScores.put("Constitution", 13);
                standardAbilityScores.put("Intelligence", 12);
                standardAbilityScores.put("Wisdom", 10);
                standardAbilityScores.put("Charisma", 8);
                break;
        }

        return standardAbilityScores;
    }

    public HashMap<String, Integer> applyRacialBonus(HashMap<String, Integer> abilityScores, String race) {

        switch(race) {
            case "Dragonborn":
                abilityScores.put("Strength", abilityScores.get("Strength") + 2);
                abilityScores.put("Charisma", abilityScores.get("Charisma") + 1);
                break;
            case "Dwarf":
                abilityScores.put("Constitution", abilityScores.get("Constitution") + 2);
                abilityScores.put("Wisdom", abilityScores.get("Wisdom") + 1);
                break;
            case "Elf":
                abilityScores.put("Dexterity", abilityScores.get("Dexterity") + 2);
                abilityScores.put("Intelligence", abilityScores.get("Intelligence") + 1);
                break;
            case "Gnome":
                abilityScores.put("Intelligence", abilityScores.get("Intelligence") + 2);
                abilityScores.put("Constitution", abilityScores.get("Constitution") + 1);
                break;
            case "Half-Elf":
                //There needs to be player choice taken into consideration for the +1's
                abilityScores.put("Charisma", abilityScores.get("Charisma") + 2);
                abilityScores.put("Strength", abilityScores.get("Strength") + 1);
                abilityScores.put("Constitution", abilityScores.get("Constitution") + 1);
                break;
            case "Half-Orc":
                abilityScores.put("Strength", abilityScores.get("Strength") + 2);
                abilityScores.put("Constitution", abilityScores.get("Constitution") + 1);
                break;
            case "Halfling":
                abilityScores.put("Dexterity", abilityScores.get("Dexterity") + 2);
                abilityScores.put("Charisma", abilityScores.get("Charisma") + 1);
                break;
            case "Human":
                abilityScores.put("Strength", abilityScores.get("Strength") + 1);
                abilityScores.put("Dexterity", abilityScores.get("Dexterity") + 1);
                abilityScores.put("Constitution", abilityScores.get("Constitution") + 1);
                abilityScores.put("Intelligence", abilityScores.get("Intelligence") + 1);
                abilityScores.put("Wisdom", abilityScores.get("Wisdom") + 1);
                abilityScores.put("Charisma", abilityScores.get("Charisma") + 1);
                break;
            case "Tiefling":
                abilityScores.put("Charisma", abilityScores.get("Charisma") + 2);
                abilityScores.put("Intelligence", abilityScores.get("Intelligence") + 1);
                break;
        }
        return abilityScores;
    }
}