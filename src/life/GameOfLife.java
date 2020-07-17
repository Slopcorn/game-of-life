package life;

import javax.swing.*;

public class GameOfLife extends JFrame {
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

        // Display the interface
        setVisible(true);

        // Program loop
        for (int i = 0; i < 200; i++) {
            generation.setText("Generation #" + universe.getGeneration());
            alive.setText("Alive: " + universe.getAlive());
            panel.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            universe.iterate();
        }
    }
}