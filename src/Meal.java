package verkocht;

public class Meal extends Item {
	String[] ingredientList;
	int timeUnit;

	public Meal(String name,int price, int timeUnit, String[] ingredient){
		this.name = name;
		this.price = price;
		//this.amount = m_Amount
		this.timeUnit = timeUnit;
		this.ingredientList = ingredient;
	}


}
