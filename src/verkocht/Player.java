package verkocht;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;

import javax.swing.JPanel;

import ui.Spritesheet;

public class Player {
    // Attributes
    private int x = 0;
    private int y = 0;
    private Item[] inventory = new Item[1];;
    private int money;
    private int xp;
    private int width = 50;
    private int height = 50;
    private Spritesheet spsh;
    private int maxItems = 1;
    private int speed = 15;

    // Constructor
    public Player() {
        x = 0;
        y = 0;
        money = 0;
        xp = 0;
        spsh = new Spritesheet(new File("Assets/Player/Spritesheet.png"));
    }

    // Move player
    public void move(char dir) {
        switch (dir) {
            case 'w':
                y -= speed;
                break;
            case 's':
                y += speed;;
                break;
            case 'a':
                x -= speed;
                break;
            case 'd':
                x += speed;
                break;
        }

        System.out.println("MOVED: x:" + x + ", y: " + y);
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
        Color c = g2d.getColor();
        
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, width, height);

        g2d.setColor(c);
        //g2d.drawImage(img, x, y, width, height, obs);
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