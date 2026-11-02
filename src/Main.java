
package verkocht;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Player player1 = new Player();
    static Scanner scanner = new Scanner(System.in);

    // Listen erstellen
    public static ArrayList<Meal> meals = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {

        // Zutaten erstellen
        Ingredient tomato = new Ingredient("Tomate", 10, 5, 2);
        Ingredient cheese = new Ingredient("Käse", 20, 7, 4);
        Ingredient noodles = new Ingredient("Nudeln", 15, 30, 3);
        Ingredient flour = new Ingredient("Mehl", 10, 60, 2);

        // Zutatenlisten erstellen
        ArrayList<Ingredient> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add(tomato);
        pizzaIngredients.add(cheese);
        pizzaIngredients.add(flour);

        ArrayList<Ingredient> pastaIngredients = new ArrayList<>();
        pastaIngredients.add(noodles);
        pastaIngredients.add(cheese);
        pastaIngredients.add(tomato);

        // Gerichte erstellen
        Meal pizza = new Meal("Pizza", 12, pizzaIngredients);
        Meal pasta = new Meal("Pasta", 10, pastaIngredients);

        // Gerichte zur Liste hinzufügen
        meals.add(pizza);
        meals.add(pasta);

        // Kunden erstellen
        Customer customer1 = new Customer("Max", 80);
        Customer customer2 = new Customer("Lisa", 90);

        // Kunden bestellen lassen
        customer1.order();
        customer2.order();

        // Anzahl der Bestellungen ausgeben
        System.out.println("Anzahl Bestellungen: " + orders.size());

        // Gerichte ausgeben
        System.out.println("Verfügbare Gerichte:");

        for (int i=0; i<meals.size(); i++) {
            System.out.println(meals.get(i).getName() + " - " + meals.get(i).getPrice() + " Euro");
        }

        while (true) {
            char direction = scanner.next().charAt(0);
            player1.move(direction);

            if (direction == 'q') {
                break;
            }

            System.out.println("X: " + player1.getX());
            System.out.println("Y: " + player1.getY());
        }

    }
}
