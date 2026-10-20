package verkocht;
import java.util.Random;

public class Customer {
	
	String name;
	int satisfication;
	
	    
	public Customer (String name, int satisfication) {
		this.name = name;
		this.satisfication = satisfication;
	}
	public void order() {
		Random random = new Random();
		Meal meal = Main.meals.get(
		        random.nextInt(Main.meals.size())
		        );
		Order order1 = new Order(234,meal, this);
		Main.orders.add(order1);
		
		
	}

}
