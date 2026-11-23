package verkocht;

import java.util.ArrayList;

public class Meal extends Item {
	private String name;
	private int price;
	private ArrayList<Ingredient> ingredientList;
	private int timeUnit;

	public Meal(String name, int price, int time, ArrayList<Ingredient> ingredient){
		this.name = name;
		this.price = price;
		this.ingredientList = ingredient;
		this.timeUnit = time;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

}
