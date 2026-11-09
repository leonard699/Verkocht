package verkocht;
import java.util.ArrayList;
import java.util.Random;


public class Verkocht {
    Random random = new Random();
	public static ArrayList<Order> orders = new ArrayList<>();
	public static ArrayList<Meal> meals = new ArrayList<>();

    public static void main(String[] args) {
        //Testdaten
		Ingredient teig = new Ingredient("Teig",1,2,3);
		Ingredient tomate = new Ingredient("Tomate",1,2,3);
		Ingredient salat = new Ingredient("Salat",1,2,3);
		Ingredient fleisch = new Ingredient("Fleisch",1,2,3);
		Ingredient broetchen = new Ingredient("Brötchen",1,2,3);
		Ingredient kaese = new Ingredient("Käse",1,2,3);
		Ingredient[] pingredients = {teig,tomate,kaese};
		meals.add(new Meal("Pizza",10,10,pingredients));
		Ingredient[] bingredients = {kaese,fleisch,broetchen,tomate,salat};
		meals.add(new Meal("Burger",13,10,bingredients));
		Ingredient[] ningredients = {teig,tomate,kaese,fleisch};
		meals.add(new Meal("Nudeln",8,10,ningredients));
	
		Customer Kunde1 = new Customer("Tom",13);
		Kunde1.order();
		Customer Kunde2 = new Customer("Tina",13);
		Kunde2.order();

        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}
