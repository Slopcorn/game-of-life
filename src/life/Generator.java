package life;

import java.util.Random;

public class Generator {
    static boolean[][] generate(int n, long seed) {
        boolean[][] world = new boolean[n][n];
        Random random = new Random(seed);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                world[i][j] = random.nextBoolean();
            }
        }

        return world;
    }
}
