package life;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame {
    boolean playing = true;
    boolean resetting = false;

    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);

        // Main panel
        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setLayout(null);
        add(panel);

        // Creating the labels that give info about which generation it is and how many cells are alive.
        JLabel generation = new JLabel();
        JLabel alive      = new JLabel();
        generation.setName("GenerationLabel");
        alive.setName("AliveLabel");
        generation.setBounds(50, 5, 200, 20);
        alive.setBounds(50, 25, 200, 20);
        panel.add(generation);
        panel.add(alive);

        // Adding the game field itself
        Universe universe = new Universe();
        universe.setName("GameWorld");
        universe.setBounds(50, 50, 400, 400);
        panel.add(universe);
        panel.repaint();

        // Adding buttons for pause and reset
        JButton pauseButton = new JButton("Pause");
        JButton resetButton = new JButton("Reset");
        pauseButton.setName("PlayToggleButton");
        resetButton.setName("ResetButton");
        pauseButton.setBounds(300, 25, 70, 20);
        resetButton.setBounds(380, 25, 70, 20);
        panel.add(pauseButton);
        panel.add(resetButton);

        // Adding functionality to buttons
        pauseButton.addActionListener(e -> {
            playing ^= true;    // Flips state of playing boolean
        });
        resetButton.addActionListener(e -> {
            resetting = true;   // Allows the program loop to reset the game instead of iterating
        });

        // Display the interface
        setVisible(true);

        // Program loop
        while (true) {
            // Handle resets
            if (resetting) {
                resetting = false;
                universe.reset();
            }
            // Game loop
            if (playing) {
                generation.setText("Generation #" + universe.getGeneration());
                alive.setText("Alive: " + universe.getAlive());
                panel.repaint();
                sleep(200);
                universe.iterate();
            } else sleep(200);  // We are paused
        }
    }

    // Method to reduce complexity in code above
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}