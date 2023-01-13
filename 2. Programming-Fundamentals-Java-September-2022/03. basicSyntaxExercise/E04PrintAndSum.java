package basicSyntaxExercise;

import java.util.Scanner;

public class E04PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни -> цяло число за начало; цяло число за край
        //2. отпечатвам всички числа в дадения диазпазон
        //3. намирам и опечатвам сумата

        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());

        int sum = 0; //сумата на числата
        for (int number = startNumber; number <= endNumber; number++) {
            System.out.print(number + " ");
            sum = sum + number;   // sum += number;
        }

        System.out.println(); //свалям курсора на нов ред
        System.out.println("Sum: " + sum);
    }
}
