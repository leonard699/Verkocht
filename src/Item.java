package verkocht;

public class Item {
    String name;
    int price;
    int amount;

    public void getAmount() {
        return amount;
    }

    public void addAmount(int amnt) {
        amount += amnt;
    }

    // rmAmount == removeAmount
    public boolean rmAmount(int amnt) {
        if (amount -= amnt < 0) {
            return false;
        }
        amount -= amnt;
    }
}
