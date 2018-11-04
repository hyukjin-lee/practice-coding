package algorithm.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class backjoon_1747 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());

        while (true) {
            if (isPrimeNumber(number)) {
                if (isFelindrom(number)) {
                   break;
                }
                number++;
            } else {
                number++;
            }
        }

        System.out.println(number);
    }

    public static boolean isPrimeNumber(int number) {
        boolean isPrimeNumber = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrimeNumber = false;
                break;
            }
        }

        return isPrimeNumber;
    }

    public static boolean isFelindrom(int number) {
        String numberString = String.valueOf(number);
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < numberString.length(); i++) {
            integers.add(Integer.parseInt(String.valueOf(numberString.charAt(i))));
        }

        List<Integer> newIntegers = new ArrayList<>();
        newIntegers.addAll(integers);
        Collections.reverse(newIntegers);

        return integers.equals(newIntegers);
    }
}
