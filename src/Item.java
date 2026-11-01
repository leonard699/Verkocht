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

    	public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
        return price;
    }

	public void setPrice(String price) {
		this.price = price;
	}

    // rmAmount == removeAmount
    public boolean rmAmount(int amnt) {
        if (amount -= amnt < 0) {
            return false;
        }
        amount -= amnt;
    }
}
