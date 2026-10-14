package verkocht;

public class Ingredient extends Item {
	int shelfLive;
	
	
	// Konstruktor
	public ingredient(String name, int amount, int shelfLife, int price){
		// i als abkürzung für ingredient
		this.name = name;
		this.amount = amount;
		this.price = price; 
	}
	// ingredient - 1 if used
	public void use() {
		this.amount =- amount;
	}

}
