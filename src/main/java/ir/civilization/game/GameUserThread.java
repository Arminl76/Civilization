package ir.civilization.game;

import ir.civilization.menu.main.GameMenuRunner;

public class GameUserThread extends Thread {

    public GameUserThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        new GameMenuRunner().run();
    }
}
