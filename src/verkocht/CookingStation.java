// von Benni
package verkocht;

// Herd und Ofen benutzen denselben Ablauf beim Kochen.
public class CookingStation extends Structure {
    private Meal meal;
    private int remainingTime;

    public CookingStation(int x, int y) {
        super(x, y);
    }

    public boolean startCooking(Meal dish, int cookingTime) {
        // Auch ein fertiges Gericht belegt das Gerät, bis es abgeholt wird.
        if (meal != null || dish == null || cookingTime <= 0) {
            return false;
        }

        meal = dish;
        remainingTime = cookingTime;
        return true;
    }

    public void tick() {
        // Pro Spielschritt vergeht eine Einheit der Kochzeit.
        if (remainingTime > 0) {
            remainingTime--;
        }
    }

    public boolean isReady() {
        return meal != null && remainingTime == 0;
    }

    public Meal takeMeal() {
        if (!isReady()) {
            return null;
        }

        Meal finishedMeal = meal;
        meal = null;
        return finishedMeal;
    }
}
