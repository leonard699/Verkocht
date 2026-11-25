package ui;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import verkocht.Verkocht;

public class Panel extends JPanel {
    private static final String BACKGROUND_PATH = "/Images/Hintergrund erste Version.png";
    private static final String POT_PATH = "/Images/Topf.png";

    private Image background;
    private Image pot;

    public Panel() {
        setLayout(null);
        setBackground(Color.blue); // Fallback, falls das Bild nicht geladen wird

        // Eclipse kopiert Bilder aus src/ nach bin/, daher ueber den Classpath laden.
        URL url = getClass().getResource(BACKGROUND_PATH);
        ImageIcon icon = url != null
            ? new ImageIcon(url)
            : new ImageIcon("src" + BACKGROUND_PATH); // Fallback beim Start aus dem Projektordner

        if (icon.getIconWidth() > 0) {
            background = icon.getImage();
        } else {
            System.err.println("Hintergrundbild nicht gefunden: " + BACKGROUND_PATH);
        }

        // Topf laden
        URL potUrl = getClass().getResource(POT_PATH);
        ImageIcon potIcon = potUrl != null
            ? new ImageIcon(potUrl)
            : new ImageIcon("src" + POT_PATH);

        if (potIcon.getIconWidth() > 0) {
            pot = potIcon.getImage();
        } else {
            System.err.println("Topfbild nicht gefunden: " + POT_PATH);
        }

        // Tastatursteuerung mit Key Bindings: funktioniert ohne besonderen Fokus
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        int[] keys = { KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT };
        char[] directions = { 'w', 'a', 's', 'd' };

        for (int i = 0; i < keys.length; i++) {
            final char direction = directions[i];
            String actionName = "move-" + direction;

            inputMap.put(KeyStroke.getKeyStroke(keys[i], 0), actionName);
            actionMap.put(actionName, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Verkocht.player1.move(direction);
                    repaint();
                }
            });
        }

        // Regelmässig neu zeichnen, damit der Hinweistext wieder verschwindet
        Timer repaintTimer = new Timer(100, e -> repaint());
        repaintTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }

        // Topf und Spieler ueber dem Hintergrund zeichnen
        if (pot != null) {
            g.drawImage(
                pot,
                Verkocht.POT_X,
                	Verkocht.POT_Y,
                Verkocht.POT_SIZE,
                Verkocht.POT_SIZE,
                this
            );
        }

        Verkocht.player1.draw((Graphics2D) g, this);

        // Roter Hinweis neben dem Spieler, z. B. "Pizza +1"
        String pickupText = Verkocht.player1.getPickupText();
        if (pickupText != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.setFont(getFont().deriveFont(Font.BOLD, 20f));
            g2d.drawString(
                pickupText,
                Verkocht.player1.getX() + Verkocht.player1.getWidth() + 10,
                Verkocht.player1.getY() + Verkocht.player1.getHeight() / 2 + 7
            );
            g2d.dispose();
        }
    }
}
