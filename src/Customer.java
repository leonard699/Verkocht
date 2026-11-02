package verkocht;
import java.util.Random;

public class Customer {
	
	String name;
	int satisfaction;
	
	    
	public Customer (String name, int satisfaction) {
		this.name = name;
		this.satisfaction = satisfaction;
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
