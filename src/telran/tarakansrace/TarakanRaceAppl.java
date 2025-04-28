package telran.tarakansrace;

import telran.tarakansrace.tarakans.Tarakan;

import java.util.Scanner;

public class TarakanRaceAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of tarakans (no more 8): ");
        int quantity = scanner.nextInt();
        if (quantity > 8) {
            quantity = 8;
        }

        System.out.print("Enter distance (int number): ");
        int distance = scanner.nextInt();

        System.out.println("Race has started");

        Thread[] threads = new Thread[quantity];
        for (int i = 0; i < quantity; i++) {
            threads[i] = new Thread(new Tarakan(i, distance));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Race has finished");
        System.out.println("Congratulations to Tarakan#" + (Tarakan.getWinner() + 1) + " (winner)");
    }
}
