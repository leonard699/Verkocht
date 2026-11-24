package verkocht;

import ui.Spritesheet;

import java.io.File;

public class Cook extends Employee{
    private static Spritesheet sprites;

    public Cook(int x, int y, String name, Item[] inventory, int price, int paycheck, File spritesheet) {
        super(x, y, name, inventory, price, paycheck);
        
        sprites.loadFromSize(100, 100);
    }

    public Cook(int x, int y, String name, Item[] inventory, int price, int paycheck) {
        super(x, y, name, inventory, price, paycheck);
    }

    public void cook(){

    }

    public void draw() {
		
	}
}




