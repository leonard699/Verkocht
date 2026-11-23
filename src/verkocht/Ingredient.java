package verkocht;

public class Ingredient extends Item {
	int shelfLife;
	
	
	// Konstruktor
	public Ingredient(String name, int amount, int shelfLife, int price){
		// i als abkürzung für ingredient
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.shelfLife = shelfLife;
	}
	// ingredient - 1 if used
	public void use() {
		this.amount =- amount;
	}

}
