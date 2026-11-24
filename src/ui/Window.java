package ui;

import javax.swing.JFrame;

import verkocht.Verkocht;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame{
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

        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                return;
            }
            
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                System.out.println(keyEvent.getKeyChar());
                switch (keyEvent.getKeyChar()) {
                    case 'w', 'a', 's', 'd':
                        Verkocht.player1.move(keyEvent.getKeyChar());
                        break;
                    default:
                        break;
                }

                UI.repaint();
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                return;
            }
        });
        


    }
}