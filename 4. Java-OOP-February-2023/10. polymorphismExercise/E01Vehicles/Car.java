package polymorphismExercise.E01Vehicles;

public class Car extends Vehicle{
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }

}
