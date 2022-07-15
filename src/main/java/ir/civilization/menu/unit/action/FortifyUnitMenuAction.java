package ir.civilization.menu.unit.action;


import ir.civilization.dto.FortifyUnitDTO;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.unit.Unit;
import ir.civilization.validator.UserValidator;

public class FortifyUnitMenuAction extends AbstractMenuAction<FortifyUnitDTO> {

    public static final FortifyUnitMenuAction INSTANCE = new FortifyUnitMenuAction();

    private FortifyUnitMenuAction() {
    }

    @Override
    public Class<FortifyUnitDTO> getDtoClazz() {
        return FortifyUnitDTO.class;
    }

    @Override
    public void takeAction(FortifyUnitDTO v) {
        // validation user authentication
        UserValidator.checkAuthentication();

        GameContext gameContext = GameHolder.getCreatedContext();
        Unit activeUnit = gameContext.getActiveUnit();
        if (activeUnit == null)
            throw new IllegalArgumentException("no active unit founded!");

        //TODO implementation

        System.out.println("unit was fortified successfully!");
    }

}
