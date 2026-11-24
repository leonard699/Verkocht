// von Benni
package verkocht;

public class CookingArea extends Structure {
    private Stove stove;
    private Oven oven;

    public CookingArea(int x, int y) {
        super(x, y);

        // Der Herd steht am Anfang des Kochbereichs, der Ofen ein Feld rechts davon.
        stove = new Stove(x, y);
        oven = new Oven(x + 1, y);
    }

    public Stove getStove() {
        return stove;
    }

    public Oven getOven() {
        return oven;
    }

    public void tick() {
        // Beide Geräte können gleichzeitig an einem Gericht arbeiten.
        stove.tick();
        oven.tick();
    }
}
