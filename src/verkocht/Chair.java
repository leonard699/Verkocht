// von Benni
package verkocht;

public class Chair extends Structure {
    // Ist customer null, ist der Stuhl frei.
    private Customer customer;

    public Chair(int x, int y) {
        super(x, y);
    }

    public boolean isOccupied() {
        return customer != null;
    }

    public boolean sitDown(Customer guest) {
        if (guest == null || isOccupied()) {
            return false;
        }

        customer = guest;
        // Der Kunde bekommt die Position vom Stuhl.
        customer.x = getXCord();
        customer.y = getYCord();
        return true;
    }

    public void standUp() {
        customer = null;
    }
}
