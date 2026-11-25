package verkocht;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player {
    // Attributes
    private int x = 100;
    private int y = 100;
    private Item[] inventory = new Item[1];;
    private int money;
    private int xp;
    private int width = 100;
    private int height = 100;
    private Image playerImage;
    private int maxItems = 1;
    private int speed = 15;
    private boolean blocked = false;
    private long blockedUntil = 0;
    private static final long BLOCK_DURATION_MS = 5000;
    private String pickupText = "";
    private long pickupTextUntil = 0;
    private static final long PICKUP_TEXT_DURATION_MS = 5000;

    // Constructor
    public Player() {
        x = 100;
        y = 100;
        money = 0;
        xp = 0;

        // Bild des Kochs mit transparentem Hintergrund laden
        URL url = getClass().getResource("/Images/Koch.png");
        ImageIcon icon = url != null
            ? new ImageIcon(url)
            : new ImageIcon("src/Images/Koch.png");

        if (icon.getIconWidth() > 0) {
            playerImage = icon.getImage();
        } else {
            System.err.println("Spielerbild nicht gefunden: /Images/Koch.png");
        }
    }

    // Move player
    public void move(char dir) {
        if (blocked) {
            // Nach 5 Sekunden darf sich der Spieler wieder bewegen.
            if (System.currentTimeMillis() < blockedUntil) {
                return;
            }
            blocked = false;
        }

        int newX = x;
        int newY = y;
        switch (dir) {
            case 'w':
                newY -= speed;
                break;
            case 's':
                newY += speed;
                break;
            case 'a':
                newX -= speed;
                break;
            case 'd':
                newX += speed;
                break;
        }

        // Beruehrt der Koch den Topf, ist er blockiert und kann sich nicht mehr bewegen.
        if (newX < Verkocht.POT_X + Verkocht.POT_SIZE
                && newX + width > Verkocht.POT_X
                && newY < Verkocht.POT_Y + Verkocht.POT_SIZE
                && newY + height > Verkocht.POT_Y) {
            blocked = true;
            blockedUntil = System.currentTimeMillis() + BLOCK_DURATION_MS;

            // Verfuegbarkeit eines Gerichts erhoehen und Hinweis anzeigen
            increaseMealAvailability();

            System.out.println("MOVED: blockiert durch Topf (5 Sekunden)");
            return;
        }

        x = newX;
        y = newY;
        System.out.println("MOVED: x:" + x + ", y: " + y);
    }

    // Erhoeht die Availability des ersten Gerichts und zeigt "+1" am Spieler an
    private void increaseMealAvailability() {
        if (Verkocht.meals.isEmpty()) {
            return;
        }

        Meal meal = Verkocht.meals.get(0);
        meal.setAvailability(meal.getAvailability() + 1);
        pickupText = meal.getName() + " +1 jetzt sind gleich "+ meal.getAvailability() + " fertig! Bitte warten...";
        pickupTextUntil = System.currentTimeMillis() + PICKUP_TEXT_DURATION_MS;
    }

    // Text wird nur angezeigt, solange die Anzeigezeit nicht abgelaufen ist
    public String getPickupText() {
        return System.currentTimeMillis() < pickupTextUntil ? pickupText : null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Pick up an item
    public void pickUp(Item item) {
        int freeSlot = -1;

        // Check if the item is already in the inventory
        for (int counter = 0; counter < inventory.length; counter++) {
            Item invItem = inventory[counter];

            if (invItem.name == item.name) {
                invItem.addAmount(item.getAmount());
                return;
            } else if (invItem == null) {
                freeSlot = counter;
            }
        }

        if (freeSlot < 0) { return; }

        // Add item if it is not already in the inventory
        inventory[freeSlot] = item;
    }

    // Drop an item
    public void drop(Item item) {
        int counter = 0;
        for (Item invItem : inventory) {
            if (invItem.getName().equals(item.getName())) {
                inventory[counter] = null;
                return;
            }
            counter++;
        }
    }

    // Get inventory
    public Item[] getInventory() {
        return inventory;
    }

    // Get position
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Get money
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // Get XP
    public int getXp() {
        return xp;
    }

    public void addXp(int amount) {
        this.xp += amount;
    }

    // Get inventory information
    public void showInventory() {
        System.out.println("Inventory:");

        for (Item item : inventory) {
            System.out.println(
                    item.getName() + " - Amount: " + item.getAmount()
            );
        }
    }

    public void draw(Graphics2D g2d, JPanel obs) {
        if (playerImage != null) {
            // Koch anstelle des roten Rechtecks zeichnen
            g2d.drawImage(playerImage, x, y, width, height, obs);
        } else {
            // Fallback, falls das Bild nicht geladen werden konnte
            Color c = g2d.getColor();
            g2d.setColor(Color.RED);
            g2d.fillRect(x, y, width, height);
            g2d.setColor(c);
        }
    }

    public void changeMoney(int change) {
        if (money - change < 0) {
            return;
        }
        money += change;
    }

    public void cook() {

    }

    public void clean() {

    }
}