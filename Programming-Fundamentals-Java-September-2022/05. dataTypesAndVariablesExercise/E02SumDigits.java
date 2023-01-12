package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class E02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни
        //стоп: числото <= 0
        //продължавам: числото > 0
        //повтаряме
        // 1. взимаме последната цифра -> % 10
        // 2. сумираме цифрата
        // 3. махаме последната цифра -> / 10
        //принртирам
        int sum = 0; //сумата на цифрите
       /* int number = Integer.parseInt(scanner.nextLine());
        while (number > 0) {
            int lastDigit = number % 10; //последна цифра
            sum += lastDigit;
            number = number / 10; //премахваме последната цифра
        }*/

        for (int number = Integer.parseInt(scanner.nextLine()); number > 0 ; number = number / 10) {
            int lastDigit = number % 10; //последна цифра
            sum += lastDigit;
        }

        System.out.println(sum);
    }
}
