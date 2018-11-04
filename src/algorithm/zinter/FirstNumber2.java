package algorithm.zinter;

import org.junit.Test;

public class FirstNumber2 {
    public int solution(int[] input) {
        int count = 0;
        int changeIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > input[i + 1]) {
                changeIndex = i;
                count++;
            }
        }

        if (count > 1) {
            return 0;
        } else {

        }
        return 0;
    }

    @Test
    public void solution() {

    }
}
