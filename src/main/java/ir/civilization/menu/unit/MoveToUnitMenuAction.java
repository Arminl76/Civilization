package ir.civilization.menu.unit;


import ir.civilization.dto.PositionDTO;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.holder.MapHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.Tile;
import ir.civilization.model.unit.Unit;

public class MoveToUnitMenuAction extends AbstractMenuAction<PositionDTO> {

    public static final MoveToUnitMenuAction INSTANCE = new MoveToUnitMenuAction();

    private MoveToUnitMenuAction() {
    }

    @Override
    public Class<PositionDTO> getDtoClazz() {
        return PositionDTO.class;
    }

    @Override
    public void takeAction(PositionDTO v) {
        GameContext gameContext = GameHolder.GTL.get();
        Unit activeUnit = gameContext.getActiveUnit();
        if (activeUnit == null)
            throw new IllegalArgumentException("no active unit founded!");

        Tile newTile = MapHolder.MAP.getMap()[v.getX()][v.getY()];
        if (!newTile.isAccessible())
            throw new IllegalArgumentException("tile is not accessible: " + newTile.getType());

        final Tile oldTile = activeUnit.getTile();
        newTile.setUnit(activeUnit);
        oldTile.removeUnit(activeUnit);
        activeUnit.setTile(newTile);
    }

}
