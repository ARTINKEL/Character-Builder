package edu.bsu.cs222;

public class Keywords {

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
        Gnome("Gnome", 20);

        private int weight;
        private String name;
        GNOME_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum DRAGONBORN_KEYWORDS {
        Dragonborn("Dragonborn", 20);

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
        Halfling("Halfling", 20);

        private int weight;
        private String name;
        HALFLING_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum HALFORC_KEYWORDS {
        HalfOrc("Half-Orc", 20);

        private int weight;
        private String name;
        HALFORC_KEYWORDS(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public enum TIEFLING_KEYWORDS {
        Tiefling("Tiefling", 20);

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
}