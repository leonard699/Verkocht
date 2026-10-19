package verkocht;

public class Player{
    private int x, y;
    private Item[] inventory = new Item[1];
    private int money;
    private int xp;

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
            default:
                break;
        }
    }

    public void cook() {

    }

    public void clean() {

    }

    public void drop(item i) {
        for (item ii : Inventory) {
            if (ii == i) {
                Inventory[ii] = null;
            }
        }
    }

    public void pickUp(Item i) {
        // freeSlot is blocked with -1 => if freeSlot is still -1 after the loop, it means the inventory is full
        int freeSlot = -1;
        
        for (int counter = 0; counter < inventory.length(); counter++) {
            Item invItem = inventory[counter];

            if (invItem.name == i.name) {
                invItem.addAmount(i.getAmount());
                return;
            } else if (invItem == null) {
                freeSlot = counter; 
            }
        }

        // return if the inventory is full
        if (freeSlot == 0) { return; }
        
        // Put the item into the inventory on the last recorded free Slot
        inventory[freeSlot] = i;  
    }
}