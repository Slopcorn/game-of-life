package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read in the size of the playing field and the seed.
        int n    = scanner.nextInt();
        int seed = scanner.nextInt();

        // Create the world.
        Universe universe = new Universe(Generator.generate(n, seed));

        // Printout the world.
        System.out.println(universe);
    }
}
