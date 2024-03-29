package encapsulationExercise.E04PizzaCalories;

public enum FlourType {
    White(1.5),
    Wholegrain(1);
    private final double value;

    FlourType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
