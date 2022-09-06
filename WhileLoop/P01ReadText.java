package L05WhileLoop;

import java.util.Scanner;

public class P01ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.nextLine();

            if (word.equals("Stop")) {
                break;
            }

            System.out.println(word);
        }

    }

}
