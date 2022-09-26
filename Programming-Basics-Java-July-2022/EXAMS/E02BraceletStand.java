package exam1;

import java.util.Scanner;

public class E02BraceletStand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double djobniNaDen = Double.parseDouble(scanner.nextLine());
        double pariKoitoPecheliNaDen = Double.parseDouble(scanner.nextLine());
        double razhodi = Double.parseDouble(scanner.nextLine());
        double cenaPodaryk = Double.parseDouble(scanner.nextLine());

        double totalDjobni = djobniNaDen * 5;
        double totalPariKoitoPecheli = pariKoitoPecheliNaDen * 5;
        double obshtoSpesteniPari = totalDjobni + totalPariKoitoPecheli;

        double obshtoSpesteniBezRazhodi = obshtoSpesteniPari - razhodi;

        if (obshtoSpesteniBezRazhodi >= cenaPodaryk) {
            System.out.printf("Profit: %.2f BGN, the gift has been purchased.", obshtoSpesteniBezRazhodi);
        } else {
            System.out.printf("Insufficient money: %.2f BGN.", cenaPodaryk - obshtoSpesteniBezRazhodi);
        }

    }
}
