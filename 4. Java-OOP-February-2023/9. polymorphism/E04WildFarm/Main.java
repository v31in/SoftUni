package polymorphism.E04WildFarm;

import polymorphism.E04WildFarm.animal.*;
import polymorphism.E04WildFarm.food.Food;
import polymorphism.E04WildFarm.food.FoodType;
import polymorphism.E04WildFarm.food.Meat;
import polymorphism.E04WildFarm.food.Vegetable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] animalParts = input.split(" ");
            String[] foodParts = scanner.nextLine().split(" ");

            Animal animal = createAnimal(animalParts);
            Food food = createFood(foodParts);

            animal.makeSound();
            animal.eat(food);
            System.out.println(animal);

            input = scanner.nextLine();
        }
    }

    private static Food createFood(String[] foodParts) {
        FoodType foodType = FoodType.valueOf(foodParts[0]);
        int quantity = Integer.parseInt(foodParts[1]);

        if (foodType == FoodType.Meat) {
            return new Meat(quantity);
        } else if (foodType == FoodType.Vegetable) {
            return new Vegetable(quantity);
        }

        return null;
    }

    private static Animal createAnimal(String[] animalParts) {
        AnimalType type = AnimalType.valueOf(animalParts[0]);

        if (type == AnimalType.Cat) {
            return new Cat(animalParts[1], Double.parseDouble(animalParts[2]), animalParts[3], animalParts[4]);
        } else if (type == AnimalType.Mouse) {
            return new Mouse(animalParts[1], Double.parseDouble(animalParts[2]), animalParts[3]);
        } else if (type == AnimalType.Tiger) {
            return new Tiger(animalParts[1], Double.parseDouble(animalParts[2]), animalParts[3]);
        } else if (type == AnimalType.Zebra) {
            return new Zebra(animalParts[1], Double.parseDouble(animalParts[2]), animalParts[3]);
        }

        return null;
    }
}
