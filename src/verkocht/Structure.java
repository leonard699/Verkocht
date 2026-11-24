package verkocht;

// Stühle, Tische und Küchengeräte haben alle eine Position im Raum.
public class Structure {
    protected int xCord;
    protected int yCord;

    public Structure(int x, int y) {
        this.xCord = x;
        this.yCord = y;
    }

    public int getXCord() {
        return xCord;
    }

    public int getYCord() {
        return yCord;
    }
}
