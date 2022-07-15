package ir.civilization.menu.cheat;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.menu.cheat.action.IncreaseCheatMenuAction;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class CheatMenu extends AbstractMenu {

    public static final CheatMenu INSTANCE = new CheatMenu();

    private static final String ACTION_INCREASE = "increase";
    private static final String FLAG_TURN = "turn";
    private static final String FLAG_GOLD = "gold";

    public static final Option OPTIONS_TURN = new Option(FLAG_TURN, FLAG_TURN, true, "turn");
    public static final Option OPTIONS_GOLD = new Option(FLAG_GOLD, FLAG_GOLD, true, "gold");

    private CheatMenu() {
    }

    @Override
    public String getMenuName() {
        return "cheat";
    }

    @Override
    public Options getCliOptions() {
        Options options = new Options();
        options.addOption(OPTIONS_TURN);
        options.addOption(OPTIONS_GOLD);
        return options;
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_INCREASE, IncreaseCheatMenuAction.INSTANCE);
        return actions;
    }

}
