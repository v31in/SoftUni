package polymorphism.E04WildFarm.animal;

import polymorphism.E04WildFarm.food.Food;
import polymorphism.E04WildFarm.food.Vegetable;

public class Zebra extends Mammal {
    public Zebra(String name, double weight, String region) {
        super(name, weight, region, AnimalType.Zebra);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Vegetable;
    }
}
