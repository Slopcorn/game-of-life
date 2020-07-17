package life;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Universe extends JPanel {
    boolean[][] state;

    private int alive;
    private int generation;

    public Universe() {
        // Generate game field.
        reset();
        // Make the size as it needs to be to fit the game field.
        // Each square is 15x15 pixels by size.
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.BLACK);
    }

    public int getAlive() {
        return alive;
    }

    public int getGeneration() {
        return generation;
    }

    public void reset() {
        alive = 0;
        generation = 1;
        state = generate();     // Generate game field.
        for (boolean[] row : state) for (boolean cell : row) if (cell) alive++; // Find how many are alive.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 40; i++) for (int j = 0; j < 40; j++) {
            if (state[i][j]) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.fillRect(i * 15 + 1, j * 15 + 1, 13, 13);
        }
    }

    public void iterate() {
        boolean[][] next = new boolean[state.length][state.length];

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                int neighbours = neighbours(i, j);
                if (state[i][j]) {
                    // If we are alive, survive if 2 or 3 neigbours.
                    next[i][j] = neighbours == 2 || neighbours == 3;
                    alive = next[i][j] ? alive : alive - 1;
                } else {
                    // If we are dead, spring to life if 3 neighbours.
                    next[i][j] = neighbours == 3;
                    alive = next[i][j] ? alive + 1 : alive;
                }
            }
        } // for end

        generation++;
        state = next;
    }

    private int neighbours(int x, int y) {
        // x and y act as coordinates
        int sum = 0;

        // Go counterclockwise, starting from the northern one.
        // Surely there is a better way to do this one?
        y = minus(y);       // North
        sum += state[x][y] ? 1 : 0;
        x = plus(x);        // East
        sum += state[x][y] ? 1 : 0;
        y = plus(y);        // South
        sum += state[x][y] ? 1 : 0;
        y = plus(y);        // South
        sum += state[x][y] ? 1 : 0;
        x = minus(x);       // West
        sum += state[x][y] ? 1 : 0;
        x = minus(x);       // West
        sum += state[x][y] ? 1 : 0;
        y = minus(y);       // North
        sum += state[x][y] ? 1 : 0;
        y = minus(y);       // North
        sum += state[x][y] ? 1 : 0;

        return sum;
    }

    private int plus(int coord) {
        return (coord + 1) % state.length;
    }

    private int minus(int coord) {
        if (coord == 0) return state.length - 1;
        else return coord - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Generation #").append(generation).append('\n');
        sb.append("Alive: ").append(alive).append("\n\n");

        for (boolean[] row : state) {
            for (boolean b : row) {
                sb.append(b ? 'O' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private static boolean[][] generate() {
        int n = 40; // Game field size is 40.
        boolean[][] world = new boolean[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                world[i][j] = random.nextBoolean();
            }
        }

        return world;
    }
}
