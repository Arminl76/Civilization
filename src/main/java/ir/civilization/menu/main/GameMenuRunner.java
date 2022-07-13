package ir.civilization.menu.main;

import java.util.Scanner;

public class GameMenuRunner implements Runnable {

    public final static String EXIT_COMMAND = "menu exit";
    private final static GameMainMenu GAME_MAIN_MENU = GameMainMenu.INSTANCE;

    public final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        System.out.print("\nplease enter a command: ");
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase(EXIT_COMMAND)) {
            GAME_MAIN_MENU.handleMenu(input);

            System.out.print("\nplease enter a command: ");
            input = scanner.nextLine();
        }

    }
}
