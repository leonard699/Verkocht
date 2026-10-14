package verkocht;

public class Player{
    private int x, y;
    private Item[1] inventory;
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
            case default:
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
        // freeSlot wird durch -1 blockiert => wenn nach dem loop immernoch -1 ist das Inventar voll
        int freeSlot = -1;
        int counter = 0;
        for (Item invItem : Inventory) {
            if (invItem.name == i.n ame) {
                invItem.addAmount(i.getAmount());
                return;
            } else if (invItem == null) {
                freeSlot = counter; 
            }
            
            counter++;
        }


    }
}