package ir.civilization.model;

import ir.civilization.model.resource.Resource;
import ir.civilization.model.terrain.Terrain;
import ir.civilization.model.terrain.TerrainFeatures;
import lombok.Data;

@Data
public class Tile {
    private String name;
    private Position position;
    private Resource resource;
    private Terrain terrainType;
    private TerrainFeatures terrainF;
    private TileSituation condition;
}
