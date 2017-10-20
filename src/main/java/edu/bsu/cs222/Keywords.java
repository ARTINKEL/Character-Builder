package edu.bsu.cs222;

public class Keywords {

    public enum RACES {
        Elf, Dwarf, Gnome, Human, Dragonborn, Halfling, HalfOrc, HalfElf, Tiefling;
    }

    public enum ELF_KEYWORDS {
        Elf("Elf", 20), Nature("Nature", 5), Fey("Fey", 8), Feywild("Feywild", 8);

        private int weight;
        private String name;
        ELF_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum DWARF_KEYWORDS {
        Dwarf("Dwarf", 20), Mountain("Mountain", 10), Forge("Forge", 5);

        private int weight;
        private String name;
        DWARF_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum GNOME_KEYWORDS {
        Gnome("Gnome", 20), Short("Short", 10);

        private int weight;
        private String name;
        GNOME_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum DRAGONBORN_KEYWORDS {
        Dragonborn("Dragonborn", 20), Scales("Scales", 20);

        private int weight;
        private String name;
        DRAGONBORN_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum HUMAN_KEYWORDS {
        Human("Human", 20);

        private int weight;
        private String name;
        HUMAN_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum HALFLING_KEYWORDS {
        Halfling("Halfling", 20), Short("Short", 10);

        private int weight;
        private String name;
        HALFLING_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum HALFORC_KEYWORDS {
        HalfOrc("Half-Orc", 20), Tusk("Tusk", 20), Tusks("Tusks", 20);

        private int weight;
        private String name;
        HALFORC_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum TIEFLING_KEYWORDS {
        Tiefling("Tiefling", 20), Tail("Tail", 20), Horns("Horns", 15);

        private int weight;
        private String name;
        TIEFLING_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum HALFELF_KEYWORDS {
        HalfElf("Half-Elf", 20);

        private int weight;
        private String name;
        HALFELF_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum CLASSES {
        Barbarian, Bard, Cleric, Druid, Fighter, Monk, Paladin, Ranger, Rogue, Sorcerer, Wizard, Warlock;
    }

    public enum BARBARIAN_KEYWORDS {
        Barbarian("Barbarian", 20);

        private int weight;
        private String name;
        BARBARIAN_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum BARD_KEYWORDS {
        Bard("Bard", 20);

        private int weight;
        private String name;
        BARD_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum CLERIC_KEYWORDS {
        Cleric("Cleric", 20);

        private int weight;
        private String name;
        CLERIC_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum DRUID_KEYWORDS {
        Druid("Druid", 20);

        private int weight;
        private String name;
        DRUID_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum FIGHTER_KEYWORDS {
        Fighter("Fighter", 20);

        private int weight;
        private String name;
        FIGHTER_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum MONK_KEYWORDS {
        Monk("Monk", 20);

        private int weight;
        private String name;
        MONK_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum PALADIN_KEYWORDS {
        Paladin("Paladin", 20);

        private int weight;
        private String name;
        PALADIN_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum RANGER_KEYWORDS {
        RANGER("RANGER", 20);

        private int weight;
        private String name;
        RANGER_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum ROGUE_KEYWORDS {
        Rogue("Rogue", 20), Stealth("Stealth", 15);

        private int weight;
        private String name;
        ROGUE_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum SORCERER_KEYWORDS {
        Sorcerer("Sorcerer", 20);

        private int weight;
        private String name;
        SORCERER_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum WIZARD_KEYWORDS {
        Wizard("Wizard", 20);

        private int weight;
        private String name;
        WIZARD_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum WARLOCK_KEYWORDS {
        Warlock("Warlock", 20), Patron("Patron", 10);

        private int weight;
        private String name;
        WARLOCK_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }
}