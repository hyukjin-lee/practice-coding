package algorithm.lin;

import java.util.Scanner;
import java.util.StringTokenizer;

public class lin1 {

    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);

        int defaultAccount = 20000;

        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            int additionalCharge = 0;
            int charge = 0;

            if(distance > 178 || distance < 4) {
                System.out.println(defaultAccount);
                return;
            }

            // @todo Write your code here.
            if (distance <= 40) {
                if (defaultAccount - 720 > 0) {
                    defaultAccount -= 720;
                } else {
                    System.out.println(defaultAccount);
                    return;
                }
            } else {
                additionalCharge = (int) Math.ceil((double)(distance - 40) / 8) * 80;
                if (defaultAccount - 720 + additionalCharge > 0) {
                    defaultAccount -= 720 + additionalCharge;
                } else {
                    System.out.println(defaultAccount);
                    return;
                }
            }

        }
        // @todo Write your code here.
        System.out.println(defaultAccount);
    }
}