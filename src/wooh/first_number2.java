package wooh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class first_number2 {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String alex = bufferedReader.readLine();
        String bob = bufferedReader.readLine();

        int alexWinCount = 0;
        int bobWinCount = 0;

        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('T', 10);
        map.put('J', 11);
        map.put('Q', 12);
        map.put('K', 13);
        map.put('A', 14);

        for (int i = 0; i < alex.length(); i++) {
            if (map.get(alex.charAt(i)) > map.get(bob.charAt(i))) {
                alexWinCount++;
            } else if (map.get(alex.valueOf(i)) == map.get(bob.valueOf(i))) {
                continue;
            } else {
                bobWinCount++;
            }
        }

        System.out.println(alexWinCount);
    }
}
