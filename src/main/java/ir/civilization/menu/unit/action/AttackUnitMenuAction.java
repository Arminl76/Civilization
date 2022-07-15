package ir.civilization.menu.unit.action;


import ir.civilization.dto.PositionDTO;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.unit.Unit;
import ir.civilization.validator.UserValidator;

public class AttackUnitMenuAction extends AbstractMenuAction<PositionDTO> {

    public static final AttackUnitMenuAction INSTANCE = new AttackUnitMenuAction();

    private AttackUnitMenuAction() {
    }

    @Override
    public Class<PositionDTO> getDtoClazz() {
        return PositionDTO.class;
    }

    @Override
    public void takeAction(PositionDTO v) {
        // validation user authentication
        UserValidator.checkAuthentication();

        GameContext gameContext = GameHolder.getCreatedContext();
        Unit activeUnit = gameContext.getActiveUnit();
        if (activeUnit == null)
            throw new IllegalArgumentException("no active unit founded!");

        //TODO implementation

        System.out.println("unit is going attack");
    }

}
