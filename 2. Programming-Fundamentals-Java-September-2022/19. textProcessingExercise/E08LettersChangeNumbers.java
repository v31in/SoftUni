package textProcessingExercise;

import java.util.Scanner;

public class E08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // "A12b s17G"
        String [] codes = input.split("\\s+"); //["A12b", "s17G"]

        double totalSum = 0; //сума от модифицираните числа на всеки код
        for (String code : codes) {
            //код: {буква}{число}{буква}
            //модифицирам си числото в кода спрямо буквите
            double modifiedNumber  = getModifiedNumber(code);
            //добавям модифицираното число към сумата
            totalSum += modifiedNumber;
        }

        System.out.printf("%.2f", totalSum);

    }
    //метод, който връща модифицираното число от кода
    private static double getModifiedNumber(String code) {
        //код: "{буква}{число}{буква}"
        //"A12b"
        char firstLetter = code.charAt(0); //'A'
        char secondLetter = code.charAt(code.length() - 1); //'b'
        double number = Double.parseDouble(code.replace(firstLetter, ' ') //" 12b"
                .replace(secondLetter, ' ') //" 12 "
                .trim()); //"12" -> 12.0

        //1. проверка за firstLetter -> главна или малка
        if (Character.isUpperCase(firstLetter)) {
            //главна -> ascii e [65; 90]
            int positionUpperLetter = (int) firstLetter - 64;
            number /= positionUpperLetter;
        } else {
            //малка -> ascii е [97; 120]
            int positionLowerLetter = (int) firstLetter - 96;
            number *= positionLowerLetter;
        }

        //2. проверка за secondLetter -> главна или малка
        if (Character.isUpperCase(secondLetter)) {
            //главна -> ascii e [65; 90]
            int positionUpperLetter = (int) secondLetter - 64;
            number -= positionUpperLetter;
        } else {
            //малка -> ascii е [97; 120]
            int positionLowerLetter = (int) secondLetter - 96;
            number += positionLowerLetter;
        }

        //връщам модифицираното число спрямо промените от буквите
        return number;
    }
}
