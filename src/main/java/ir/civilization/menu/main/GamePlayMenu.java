package ir.civilization.menu.main;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.cheat.CheatMenu;
import ir.civilization.menu.info.InfoMenu;
import ir.civilization.menu.map.MapMenu;
import ir.civilization.menu.profile.ProfileMenu;
import ir.civilization.menu.select.SelectMenu;
import ir.civilization.menu.unit.UnitMenu;
import ir.civilization.menu.user.UserGameMenu;

import java.util.Arrays;
import java.util.List;

public class GamePlayMenu {

    private final List<AbstractMenu> menus;

    public static final GamePlayMenu INSTANCE = new GamePlayMenu();

    private GamePlayMenu() {
        this.menus = Arrays.asList(
                InfoMenu.INSTANCE,
                ProfileMenu.INSTANCE,
                MapMenu.INSTANCE,
                SelectMenu.INSTANCE,
                UnitMenu.INSTANCE,
                UserGameMenu.INSTANCE,
                CheatMenu.INSTANCE
        );
    }

    public void handleMenu(String input) {
        for (AbstractMenu menu : menus) {
            try {
                menu.run(input);
            } catch (Exception e) {
                String message = e.getMessage();
                if (message != null)
                    System.out.println(message);
                else
                    e.printStackTrace();
            }
        }
    }

}
