package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int  n    = scanner.nextInt();      // Size of the field
        long seed = scanner.nextLong();     // The random seed
        int  gens = scanner.nextInt();      // How many generations

        // Create the world.
        Universe universe = new Universe(Generator.generate(n, seed));

        // Simulate changes
        for (int i = 0; i < gens; i++) {
            universe.iterate();
        }

        // Printout the world.
        System.out.println(universe);
    }
}
