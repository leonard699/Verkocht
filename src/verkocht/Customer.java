package verkocht;
import java.util.Random;
import java.util.ArrayList;

public class Customer {
	protected String name;
	protected int satisfaction;
	protected int x, y;
	protected boolean gender;
	protected String[] maleFirstNames = {
		"Tom", "Jonathan", "Charlie", "Jensen", "Leonard", "Lucka", "Mahir Mahir"
	};

	protected String[] femaleFirstNames = {
		"Timea", "Paula", "Ariel", "Miguelita", "Judith", "Moira"
	};
	
	protected String[] lastnames = {"Kirk", "Huang", "Goon", "Doshi", "Son", "Miguel"};

	private static Random random = new Random();

	public Customer(int satisfaction, int xCord, int yCord) {
		this.gender = random.nextBoolean();
		if(gender == true){
			this.name = maleFirstNames[random.nextInt(maleFirstNames.length)] + " " + lastnames[random.nextInt(lastnames.length)];
		}else{
			this.name = femaleFirstNames[random.nextInt(femaleFirstNames.length)] + " " + lastnames[random.nextInt(lastnames.length)];
		}
		this.satisfaction = satisfaction;
		this.x = xCord;
		this.y = yCord;
	}
	public int getXCord(){
		return this.x;
	}
	public int getYCord(){
		return this.y;
	}
	public void setX(int newX){
		this.x = newX;
	}
	public void setY(int newY){
		this.y = newY;
	}
	public boolean getGender(){
		return this.gender;
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
