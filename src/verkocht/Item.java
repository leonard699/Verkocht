package verkocht;

public class Item {
    String name;
    int price;
    int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount() {
        this.amount = amount;
    }

    public void addAmount(int amnt) {
        amount += amnt;
    }

    public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
        return price;
    }

	public void setPrice(int price) {
		this.price = price;
	}

    public boolean reduceAmount(int amnt) {
        if (amount - amnt < 0) {
            return false;
        }
        amount -= amnt;
        return true;
    }
}
