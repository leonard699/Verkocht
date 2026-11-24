package ui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import verkocht.Verkocht;

public class Panel extends JPanel {
    public Panel() {
        setLayout(null);
        setBackground(Color.blue);
    }

    @Override 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("a");
        Graphics2D g2d = (Graphics2D) g;
        Verkocht.player1.draw(g2d, this);
    }
}
