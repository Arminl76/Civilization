package ir.civilization.game;

import ir.civilization.model.Civilization;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameTurnThread extends Thread {

    public static final Object ROUND_LOCK = new Object();

    private final List<Thread> userThreads;

    public GameTurnThread(List<Civilization> civilizations) {
        ArrayList<Thread> list = new ArrayList<>();
        for (Civilization civilization : civilizations) {
            list.add(new GameUserThread(civilization));
        }
        this.userThreads = Collections.unmodifiableList(list);

    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    @SneakyThrows
    public void run() {
        List<Thread> userThreads = this.userThreads;

        while (true) {
            for (Thread userThread : userThreads) {
                Thread thread = new Thread(userThread, userThread.getName());
                thread.start();
                thread.join();
            }
        }

    }
}
