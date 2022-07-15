package ir.civilization.menu.cheat.action;


import ir.civilization.dto.IncreaseCheatDTO;
import ir.civilization.game.GameTurnThread;
import ir.civilization.holder.GameHolder;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.Civilization;
import ir.civilization.model.Treasury;
import ir.civilization.validator.UserValidator;

public class IncreaseCheatMenuAction extends AbstractMenuAction<IncreaseCheatDTO> {

    public static final IncreaseCheatMenuAction INSTANCE = new IncreaseCheatMenuAction();

    private IncreaseCheatMenuAction() {
    }

    @Override
    public Class<IncreaseCheatDTO> getDtoClazz() {
        return IncreaseCheatDTO.class;
    }

    @Override
    public void takeAction(IncreaseCheatDTO v) {
        // validation user authentication
        UserValidator.checkAuthentication();

        if (v.getTurn() != null) {
            final int oldTurn = GameTurnThread.currentTurn;
            GameTurnThread.currentTurn += v.getTurn();
            System.out.printf("Turn cheat activated successfully! now: %d , was: %d\n", GameTurnThread.currentTurn, oldTurn);
        } else if (v.getGold() != null) {
            Civilization civilization = GameHolder.getCreatedContext().getCivilization();
            if (civilization == null)
                throw new IllegalStateException("Civilization is null!");

            Treasury treasury = civilization.getTreasury();
            final int oldValue = treasury.getCoins();
            treasury.earn(v.getGold());

            System.out.printf("Gold cheat code activated successfully! now: %d , was: %d\n", treasury.getCoins(), oldValue);
        }
    }

}
