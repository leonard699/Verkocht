package verkocht;
import java.util.ArrayList;
import java.util.Random;


public class Verkocht {
    Random random = new Random();
	public static ArrayList<Order> orders = new ArrayList<>();
	public static ArrayList<Meal> meals = new ArrayList<>();

    public static void main(String[] args) {
        String[] pingredients = {"Mehl","Tomaten","Käse"};
		meals.add(new Meal("Pizza",10,10,pingredients));
		String[] bingredients = {"Salat","Fleisch","Brötchen"};
		meals.add(new Meal("Burger",13,10,bingredients));
		String[] ningredients = {"Mehl","Eier","Pesto"};
		meals.add(new Meal("Nudeln",8,10,ningredients));
		// Nur zum testen.
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
