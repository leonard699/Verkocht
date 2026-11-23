package verkocht;

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Player {
    // Attributes
    private int x;
    private int y;
    private ArrayList<Item> inventory;
    private int money;
    private int xp;
    private BufferedImage img; 
    private int width, height = 50;

    // Constructor
    public Player() {
        this.x = 0;
        this.y = 0;
        this.inventory = new ArrayList<>();
        this.money = 0;
        this.xp = 0;
    }

    // Move player
    public void move(char dir) {
        switch (dir) {
            case 'w':
                y--;
                break;
            case 's':
                y++;
                break;
            case 'a':
                x--;
                break;
            case 'd':
                x++;
                break;
        }
    }

    // Pick up an item
    public void pickUp(Item item) {

        // Check if the item is already in the inventory
        for (Item invItem : inventory) {

            if (invItem.getName().equals(item.getName())) {
                invItem.addAmount(item.getAmount());
                return;
            }
        }

        // Add item if it is not already in the inventory
        inventory.add(item);
    }

    // Drop an item
    public void drop(Item item) {

        for (Item invItem : inventory) {

            if (invItem.getName().equals(item.getName())) {
                inventory.remove(invItem);
                return;
            }
        }
    }

    // Get inventory
    public ArrayList<Item> getInventory() {
        return new ArrayList<>(inventory);
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

    public void draw(Graphics2D g2d, JFrame obs) {
        g2d.drawImage(img, x, y, width, height, obs);
    }

    public void cook() {

    }

    public void clean() {

    }
}
