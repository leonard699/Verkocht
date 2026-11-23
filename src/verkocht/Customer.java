package verkocht;
import java.util.Random;

public class Customer {
	protected String name;
	protected int satisfaction;
	protected int x, y;
	    
	public Customer(String name, int satisfaction, int xCord, int yCord) {
		this.name = name;
		this.satisfaction = satisfaction;
		this.x = xCord;
		this.y = yCord;
	}

	public void order() {
		Random random = new Random();
		Meal meal = Verkocht.meals.get(
		        random.nextInt(Verkocht.meals.size())
		        );
		Order order1 = new Order(234,meal, this);
		Verkocht.orders.add(order1);
	}

	public void lowerSatisfaction(int low) {
		if (satisfaction - low < 0) {
			getOut();
		}else{
		this.satisfaction -= low;
		}
	}

	public void getOut() {
		//something : go out
	}

}
