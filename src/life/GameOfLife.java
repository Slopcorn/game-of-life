package life;

import javax.swing.*;

public class GameOfLife extends JFrame {
    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        // Main panel
        JPanel panel = new JPanel();
        add(panel);

        // Creating the labels that give info about which generation it is and how many cells are alive.
        JLabel generation = new JLabel();
        JLabel alive      = new JLabel();
        generation.setName("GenerationLabel");
        alive.setName("AliveLabel");
        panel.add(generation);
        panel.add(alive);

        generation.setText("generation");
        alive.setText("alive");


        setVisible(true);
    }
}