package verkocht;

public class Meal extends Item {
	private String name
	private int price
	private ArrayList<String> ingredientList;
	private int timeUnit;

	public Meal(String name, int price, ArrayList<String> ingredient){
		this.name = name;
		this.price = price;
		this.ingredientList = ingredient;
	}

	public ArrayList<String> getIngredientsList() {
        return ingredientsList;
    }

	public void setIngredientsList(ArrayList<String> ingredientsList) {
		this.price = ingredientsList;
	}

}
