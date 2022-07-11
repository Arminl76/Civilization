package ir.civilization.model.unit;

import ir.civilization.model.Civilization;
import ir.civilization.model.Tile;
import ir.civilization.model.resource.Resource;
import ir.civilization.model.technology.Technology;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Unit {
    private String name;
    private int cost;
    private String combatType;
    private Integer combatStrength;
    private Integer rangedCombatStrength;
    private int movement;
    private Resource resourcesRequired;
    private Technology technologyRequired;
    private UnitType type;
    private Tile tile;
    private Civilization civilization;

    private int baseEndurance;
    private int endurance;
    private int pay;
    private int initialGoldCost;
    private int initialFoodCost;
    private int initialResourceCost;
    private int initialHappinessCost;
    private boolean canAttack;

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", combatType='" + combatType + '\'' +
                ", combatStrength=" + combatStrength +
                ", rangedCombatStrength=" + rangedCombatStrength +
                ", movement=" + movement +
                ", resourcesRequired=" + resourcesRequired +
                ", technologyRequired=" + technologyRequired +
                ", type=" + type +
                '}';
    }
}