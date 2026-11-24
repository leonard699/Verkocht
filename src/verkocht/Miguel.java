package verkocht;

//CODE BY ADAM
public class Miguel extends Customer{
    public Miguel(int x, int y) {
        super(10, x, y);
        this.name = "Miguel Migel";
    }

    public void miguelMove() {
        if(this.satisfaction <= 0){
            Verkocht.player1.changeMoney(-50);
        }
    }
}