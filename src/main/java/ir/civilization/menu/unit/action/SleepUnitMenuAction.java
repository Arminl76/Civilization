package ir.civilization.menu.unit.action;


import ir.civilization.dto.EmptyCmdLoader;
import ir.civilization.holder.GameContext;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.unit.Unit;
import ir.civilization.validator.UserValidator;

public class SleepUnitMenuAction extends AbstractMenuAction<EmptyCmdLoader> {

    public static final SleepUnitMenuAction INSTANCE = new SleepUnitMenuAction();

    private SleepUnitMenuAction() {
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

        System.out.println("unit is going to sleep!");
    }

}
