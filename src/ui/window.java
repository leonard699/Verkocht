package ui;

import javax.swing.JFrame;

import verkocht.Verkocht;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;


public class window extends JFrame{
    public window() {
        setSize(1280, 720);
        setVisible(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setFocusable(true);
        setDefaultCloseOperation(3);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                return;
            }
            
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (Arrays.asList(new char[]{'w', 'a', 's', 'd'}).contains(keyEvent.getKeyChar())) {
                    System.out.println(keyEvent.getKeyChar());
                    Verkocht.player1.move(keyEvent.getKeyChar());

                    System.out.println("X: " + Verkocht.player1.getX());
                    System.out.println("Y: " + Verkocht.player1.getY());
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                return;
            }
        });
    }

    
}
