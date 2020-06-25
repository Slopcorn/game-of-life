package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // For now, this will simply be a printout of a possible
        // initial state.

        int n    = scanner.nextInt();
        int seed = scanner.nextInt();
        Random random = new Random(seed);

        // This loop prints an initial state.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(random.nextBoolean() ? 'O' : ' ');
            }
            System.out.println();   // newline
        }

    }
}
