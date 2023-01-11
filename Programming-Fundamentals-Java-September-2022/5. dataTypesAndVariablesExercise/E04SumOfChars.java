package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class E04SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни дании -> брой символи
        //за всеки символ повтаряме:
        // 1. въвеждаме стойност
        // 2. аски кода на символа
        // 3. сумирам
        int sum = 0; //сума от кодовете
        int countSymbols = Integer.parseInt(scanner.nextLine());
        for (int symbol = 1; symbol <=  countSymbols; symbol++) {
            sum += scanner.nextLine().charAt(0);
        }

        System.out.printf("The sum equals: %d", sum);
    }
}
