package ir.civilization.model.resource;

import ir.civilization.model.improvement.Improvement;
import ir.civilization.model.terrain.Terrain;
import lombok.Data;

@Data
public class Resource {

    private String name;
    private int food;
    private boolean production;
    private int gold;
    private Terrain canBeFoundOn;
    private ResourceType type;
    private Improvement improvementNeeded;
    private String reqTechnology;
}
