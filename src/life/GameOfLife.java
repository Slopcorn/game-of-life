package life;

import javax.swing.*;

public class GameOfLife extends JFrame {
    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(null);    // Center window
        setVisible(true);
    }
}