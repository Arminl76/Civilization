package ir.civilization.menu.main;

import java.util.Scanner;

public class GameMenuRunner implements Runnable {

    public final static String EXIT_COMMAND = "menu exit";
    private final static GameMainMenu GAME_MAIN_MENU = GameMainMenu.INSTANCE;
    private final static GamePlayMenu GAME_PLAY_MENU = GamePlayMenu.INSTANCE;

    public GameMenuRunner(Mode mode) {
        this.mode = mode;
    }

    public enum Mode {
        PLAY, MAIN
    }

    private final Mode mode;

    public final static Scanner SCANNER = new Scanner(System.in);

    @Override
    public void run() {
        System.out.print("\nplease enter a command: ");
        String input = SCANNER.nextLine();
        while (!input.equalsIgnoreCase(EXIT_COMMAND)) {
            if (mode == Mode.PLAY)
                GAME_PLAY_MENU.handleMenu(input);
            else if (mode == Mode.MAIN)
                GAME_MAIN_MENU.handleMenu(input);
            else
                System.out.println("not valid mode");

            System.out.print("\nplease enter a command: ");
            input = SCANNER.nextLine();
        }

    }
}
