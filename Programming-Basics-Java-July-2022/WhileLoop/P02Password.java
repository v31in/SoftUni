package L05WhileLoop;

import java.util.Scanner;

public class P02Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String pass = scanner.nextLine();

        String inputData = scanner.nextLine();
        while (!inputData.equals(pass)) {

            inputData = scanner.nextLine();
        }

        System.out.printf("Welcome %s!", username);

    }
}
