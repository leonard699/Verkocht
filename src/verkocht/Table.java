package verkocht;

public class Table extends Structure {
    // Auf dem Tisch ist Platz für ein Gericht.
    private Meal meal;

    public Table(int x, int y) {
        super(x, y);
    }

    public boolean placeMeal(Meal dish) {
        if (dish == null || meal != null) {
            return false;
        }

        meal = dish;
        return true;
    }

    public Meal takeMeal() {
        // Gericht kurz merken, damit wir den Tisch leeren und es zurückgeben können.
        Meal takenMeal = meal;
        meal = null;
        return takenMeal;
    }
}
