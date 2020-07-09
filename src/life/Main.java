package life;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new GameOfLife();
        /*
        Scanner scanner = new Scanner(System.in);

        // Get field size.
        int  n    = scanner.nextInt();

        // Create the world.
        Universe universe = new Universe(Generator.generate(n));

        // Simulate changes for 25 turns
        for (int i = 0; i < 10; i++) {
            System.out.println(universe);       // Print state
            universe.iterate();                 // Process the next state
            // Try to pause before next iter
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearConsole();                     // Clear the console for the next state
        }
        */
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) { }

    }
}
