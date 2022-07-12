package ir.civilization.menu.unit;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class UnitMenu extends AbstractMenu {

    public static final UnitMenu INSTANCE = new UnitMenu();

    private static final String ACTION_MOVETO = "moveto";
    private static final String ACTION_DELETE = "delete";

    private static final String FLAG_X = "x";
    private static final String FLAG_Y = "y";

    public static final Option OPTIONS_X = new Option(FLAG_X, FLAG_X, true, "x pos");
    public static final Option OPTIONS_Y = new Option(FLAG_Y, FLAG_Y, true, "y pos");


    private UnitMenu() {
    }

    @Override
    public String getMenuName() {
        return "unit";
    }

    @Override
    public Options getCliOptions() {
        Options options = new Options();
        options.addOption(OPTIONS_X);
        options.addOption(OPTIONS_Y);
        return options;
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_MOVETO, MoveToUnitMenuAction.INSTANCE);
        actions.put(ACTION_DELETE, DeleteUnitMenuAction.INSTANCE);
        return actions;
    }

}
