package ir.civilization.game;

import ir.civilization.model.Civilization;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameTurnThread extends Thread {

    // TODO implementation
    private static final int MAX_TURN = 20;

    private final List<Thread> userThreads;

    public GameTurnThread(List<Civilization> civilizations) {
        ArrayList<Thread> list = new ArrayList<>();
        for (Civilization civilization : civilizations) {
            list.add(new GameUserThread(civilization));
        }
        this.userThreads = Collections.unmodifiableList(list);

    }

    public static int currentTurn = 0;

    @Override
    @SneakyThrows
    public void run() {
        List<Thread> userThreads = this.userThreads;

        while (currentTurn < MAX_TURN) {
            for (Thread userThread : userThreads) {
                System.out.printf("\n%s's turn! \n", userThread.getName());
                Thread thread = new Thread(userThread, userThread.getName());
                thread.start();
                thread.join();
            }
            currentTurn++;
        }

    }
}
