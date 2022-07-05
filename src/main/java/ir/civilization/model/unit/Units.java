package ir.civilization.model.unit;

import ir.civilization.model.Tile;
import ir.civilization.model.resource.Resource;
import ir.civilization.model.technology.Technology;
import lombok.Data;

@Data
public class Units {
    private String name;
    private int cost;
    private String combatType;
    private Integer combatStrength;
    private Integer rangedCombatStrength;
    private int movement;
    private Resource resourcesRequired;
    private Technology technologyRequired;
    private UnitType type;
    private Tile haveTile;
}
