package ir.civilization.model;

import ir.civilization.model.map.MapObject;
import ir.civilization.model.resource.Resource;
import ir.civilization.model.terrain.Terrain;
import ir.civilization.model.terrain.TerrainFeatures;
import ir.civilization.model.unit.Unit;
import lombok.Data;

@Data
public class Tile {
    private Resource resource;
    private Terrain terrainType;
    private TerrainFeatures terrainF;
    private TileSituation condition;

    private TerrainType type;
    private Position position;
    private MapObject occupant;

    private Unit unitNez;
    private Unit unitGNez;

    private boolean hasRiver;

    public Tile(MapObject occupant, Position position, boolean hasRiver) {
        this.occupant = occupant;
        this.position = position;
        this.hasRiver = hasRiver;
    }

    public boolean isEmpty() {
        return occupant == null;
    }
}
