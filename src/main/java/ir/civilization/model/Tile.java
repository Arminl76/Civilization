package ir.civilization.model;

import ir.civilization.model.map.MapObject;
import ir.civilization.model.resource.Resource;
import ir.civilization.model.terrain.Terrain;
import ir.civilization.model.terrain.TerrainFeatures;
import ir.civilization.model.unit.CivilianUnit;
import ir.civilization.model.unit.MilitaryUnit;
import ir.civilization.model.unit.Unit;
import ir.civilization.model.unit.UnitType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Tile {

    private Resource resource;
    private Terrain terrainType;
    private TerrainFeatures terrainF;
    private TileSituation condition;

    private TerrainType type;
    private Position position;
    private MapObject occupant;

    private MilitaryUnit unitNez;
    private CivilianUnit unitGNez;

    private boolean hasRiver;

    public Tile(MapObject occupant, Position position, boolean hasRiver) {
        this.occupant = occupant;
        this.position = position;
        this.hasRiver = hasRiver;
    }

    public void setUnit(Unit unit) {
        if (unit instanceof MilitaryUnit) {
            if (this.unitNez != null)
                throw new IllegalArgumentException("military unit is not empty");

            unitNez = (MilitaryUnit) unit;
        }
        else if (unit instanceof CivilianUnit) {
            if (this.unitNez != null)
                throw new IllegalArgumentException("civilian unit is not empty");

            unitGNez = (CivilianUnit) unit;
        }
    }

    public void removeUnit(Unit unit) {
        if (unit.equals(this.unitNez))
            unitNez = null;
        else if (unit.equals(this.unitGNez))
            unitGNez = null;
    }

    public boolean isEmpty() {
        return occupant == null;
    }

    public boolean isNotAccessible() {
        return !this.isAccessible();
    }

    public boolean isAccessible() {
        List<TerrainFeatureType> terrainFeatures = this.getType().getTerrainFeatures();
        Optional<TerrainFeatureType> terrainFeature = terrainFeatures.stream()
                .filter(tf -> tf == TerrainFeatureType.FORREST)
                .findAny();
        return type != TerrainType.HILL && this.type != TerrainType.MOUNTAIN && !terrainFeature.isPresent();
    }

    public Unit getUnit(UnitType unitType) {
        switch (unitType) {
            case COMBAT:
                return this.getUnitNez();
            case NONCOMBAT:
                return this.getUnitGNez();
            default:
                throw new IllegalStateException("WTF");
        }
    }

    public List<Unit> getUnits() {
        List<Unit> units = new ArrayList<>();
        if (this.getUnitNez() != null)
            units.add(this.getUnitNez());
        if (this.getUnitGNez() != null)
            units.add(this.getUnitGNez());
        return units;
    }
}
