package ir.civilization.menu.unit.action;


import ir.civilization.dto.EmptyCmdLoader;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.unit.Unit;
import ir.civilization.validator.UserValidator;

public class CancelUnitMenuAction extends AbstractMenuAction<EmptyCmdLoader> {

    public static final CancelUnitMenuAction INSTANCE = new CancelUnitMenuAction();

    private CancelUnitMenuAction() {
    }

    @Override
    public Class<EmptyCmdLoader> getDtoClazz() {
        return EmptyCmdLoader.class;
    }

    @Override
    public void takeAction(EmptyCmdLoader v) {
        // validation user authentication
        UserValidator.checkAuthentication();

        GameContext gameContext = GameHolder.getCreatedContext();
        Unit activeUnit = gameContext.getActiveUnit();
        if (activeUnit == null)
            throw new IllegalArgumentException("no active unit founded!");

        //TODO implementation

        System.out.println("unit actions canceled successfully");
    }

}
