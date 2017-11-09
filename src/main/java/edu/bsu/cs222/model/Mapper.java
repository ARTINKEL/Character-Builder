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


}