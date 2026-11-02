package verkocht;

public class Employee {
	private int xCord;
	private int yCord;
	private String name;
	private int xp;
	private Item[] inventory;
    private int price;
    private int paycheck;

	public Employee(int x, int y, String name, Item[] inventory, int price, int paycheck){
		this.xCord = x;
		this.yCord = y;
		this.name = name;
		this.inventory = inventory;
		this.price = price;
		this.paycheck = paycheck;
	}
	
	//Koordinaten setten
	public void setCords(int x, int y) {
		this.xCord = x;
		this.yCord = y;
	}
    //x-Koordinate get
	public int getXCord() {
		return this.xCord;
	}
    //y-Koordinate get
	public int getYCord() {
		return this.yCord;
	}
	//name ändern
	public void setName(String newName) {
		this.name = newName;
	}
    //name abrufen
	public String getName() {
		return this.name;
	}
    //xp ändern
	public void setXP(int exp) {
		this.xp = exp;
	}
    //xp-Stand abrufen
	public int getXP() {
		return this.xp;
	}
    //xp addieren
	public void addExp(int plusExp) {
		this.xp += plusExp;
	}
    //move Methode (pathfinding)
	public void move(int targetX, int targetY) {
		//insert pathfinding zum Ziel
	}
    /*Item-pickup Methode
	public void pickUp(item i) {
		if() {
			//insert item pickup lines + if-clause
		}
			
		}
    //Item-drop Methode    
	public void drop(item i) {
		if() {
			//insert item drop line + if-clause
		}
	} */
			
}