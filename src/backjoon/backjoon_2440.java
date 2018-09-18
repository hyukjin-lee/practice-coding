package backjoon;

import java.util.Scanner;

public class backjoon_2440 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {

            for (int j = 0; j < i-1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < number - i + 1; j++) {
                System.out.print("*");
            }


        }
    }
}
