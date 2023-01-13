package textProcessingExercise;

import java.util.Scanner;

public class E01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        String input = scanner.nextLine(); //"sh, too_long_username, !lleg@l ch@rs, jeffbutt"
        String [] usernames = input.split(", "); // ["sh", "too_long_username", "!lleg@l ch@rs", "jeffbutt"]

        //2. проверка дали usernames са валидни
        for (String username : usernames) {
            //ако username е валиден
            if(isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }

    //метод, който проверява дали username е валиден
    //true -> ако username е валиден
    //false -> ако username не е валиден
    private static boolean isValidUsername(String username) {
        //1. валидна дължина -> [3; 16]
        if (username.length() < 3 || username.length() > 16) {
            //невалидна дължина -> невалиден username
            return false;
        }
        //валидна дължина


        //2. валидно съдържание -> букви, цифри, -, _
        //username = "test".toCharArray() -> ['t', 'e', 's', 't']
        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                //невалиден символ -> невалиден username
                return false;
            }
        }

        //валидна дължина и съдържание
        return true;
    }
}
