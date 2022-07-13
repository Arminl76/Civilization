package ir.civilization.game;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameTurnThread extends Thread {

    private final List<Thread> userThreads;

    public GameTurnThread(List<String> players) {
        ArrayList<Thread> list = new ArrayList<>();
        for (String player : players) {
            list.add(new GameUserThread(player));
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
                System.out.printf("%s's turn\n", userThread.getName());
                userThread.run();
                userThread.join();
            }
        }

    }
}
