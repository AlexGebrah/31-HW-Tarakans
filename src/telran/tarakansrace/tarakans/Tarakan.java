package telran.tarakansrace.tarakans;

import java.util.Random;

public class Tarakan implements Runnable {
    private int number;
    private int distance;
    private static boolean winner = false;

    public Tarakan(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    @Override
    public void run() {
        System.out.println("Tarakan#" + (number + 1) + " has started");
        for (int i = 0; i < distance; i++) {
            System.out.println("Tarakan#" + (number + 1) + " at ring " + (i + 1));
            try {
                Thread.sleep(2 + new Random().nextInt(4));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Tarakan#" + (number + 1) + " has finished");
        if (!winner) {
            winner = true;
            System.out.println("Congratulations to Tarakan#" + (number + 1) + " (winner)");
        }

    }
}
