package P06NestedLoopsExercise;

import java.util.Scanner;

public class E01NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int number = 1;
        boolean isBigger = false;

        for (int rows = 1; rows <= n ; rows++) {

            for (int cols = 1; cols <= rows ; cols++) {

                System.out.print(number + " ");
                number++;

                if (number > n) {
                    isBigger = true;
                    break;
                }
            }
            if  (isBigger) {
                break;
            }

            System.out.println();

        }

    }
}
