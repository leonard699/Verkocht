package verkocht;

import java.util.List;
import java.util.Scanner;

import ui.Window;

import java.util.ArrayList;
import java.util.Random;


public class Verkocht {
	// Position und Groesse des Topfes auf dem Spielfeld
	public static final int POT_X = 300;
	public static final int POT_Y = 130;
	public static final int POT_SIZE = 100;

	public static Player player1 = new Player();
    static Scanner scanner = new Scanner(System.in);
    Random random = new Random();
	public static ArrayList<Order> orders = new ArrayList<>();
	public static ArrayList<Customer> customers = new ArrayList<>();
	public static ArrayList<Meal> meals = new ArrayList<>();

    public static void main(String[] args) {
        //Testdaten
		//Zutaten
		Ingredient teig = new Ingredient("Teig",1,2,3);
		Ingredient tomate = new Ingredient("Tomate",1,2,3);
		Ingredient salat = new Ingredient("Salat",1,2,3);
		Ingredient fleisch = new Ingredient("Fleisch",1,2,3);
		Ingredient broetchen = new Ingredient("Brötchen",1,2,3);
		Ingredient kaese = new Ingredient("Käse",1,2,3);
		//Gerichte
		Ingredient[] pingredients = {teig,tomate,kaese};
        meals.add(new Meal("Pizza",10,10,new ArrayList<>(List.of(pingredients))));
		Ingredient[] bingredients = {kaese,fleisch,broetchen,tomate,salat};
		meals.add(new Meal("Burger",13,10,new ArrayList<>(List.of(bingredients))));
		Ingredient[] ningredients = {teig,tomate,kaese,fleisch};
		meals.add(new Meal("Nudeln",8,10,new ArrayList<>(List.of(ningredients))));
		//Kunden
		Customer Kunde1 = new Customer(13, 0, 0);
		Kunde1.order();
		customers.add(Kunde1);
		Customer Kunde2 = new Customer(13,0, 1);
		Kunde2.order();
		customers.add(Kunde2);

		Lib.init();

		for (Customer k : customers) {
			k.lowerSatisfaction(1);
		}

        System.out.println("Hello and welcome!");

		// Anzahl der Bestellungen ausgeben
        System.out.println("Anzahl Bestellungen: " + orders.size());

        // Gerichte ausgeben
        System.out.println("Verfuegbare Gerichte:");

        for (int i=0; i<meals.size(); i++) {
            System.out.println(meals.get(i).getName() + " - " + meals.get(i).getPrice() + " Euro");
        }

        new Window();

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }

	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
