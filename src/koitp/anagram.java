package koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String word1 = bufferedReader.readLine();
        String word2 = bufferedReader.readLine();

        int count = 0;

        char[] sortedWord1 = word1.toCharArray();

        Arrays.sort(sortedWord1);

        word1 = String.valueOf(sortedWord1);

        for (int i = 0; i < word2.length() - word1.length() + 1; i++) {
            char[] sortedWord2 = new char[word1.length()];
            String resultWord2;

            for (int j = i; j < i + word1.length(); j++) {
                sortedWord2[j - i] = word2.charAt(j);
            }

            Arrays.sort(sortedWord2);
            resultWord2 = String.valueOf(sortedWord2);

            if (resultWord2.equals(word1)) {
                count++;
            }
        }

        System.out.println(count);

    }
}
