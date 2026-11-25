package ui;

import javax.swing.JFrame;

public class Window extends JFrame {
    Panel UI;

    public Window() {
        super("Verkocht");
        UI = new Panel();
        add(UI);
        setLocationRelativeTo(null);
        setSize(1280, 720);
        setAlwaysOnTop(true);
        setFocusable(true);
        setResizable(false);
        setDefaultCloseOperation(3);
        setVisible(true);
    }
}
