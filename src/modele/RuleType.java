package modele;

public enum RuleType {
    STANDARD("Standard Rules"),
    MAZE("Maze Rules"),
    SEEDS("Seeds Rules"),
    TWO_BY_TWO("Two By Two Rules"),
    DAY_AND_NIGHT("Day And Night Rules"),
    HIGH_LIFE("High Life Rules");

    private final String rulesName;

    RuleType(String rulesName) {
        this.rulesName = rulesName;
    }

    public String getRulesName() {
        return rulesName;
    }
}