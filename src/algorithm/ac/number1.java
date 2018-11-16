package algorithm.ac;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class number1 {

    public int solution(int n, int[] v) {
        int answer = 0;
        int sum = 0;
        int sum1 = 0;
        int sum2;

        for (int i = 0; i < n; i++) {
            sum += v[i];
        }

        sum2 = sum;
        sum = Math.abs(sum);

        for (int i = 0; i < n; i++) {
            sum2 -= v[i];
            sum1 += v[i];

            answer = sum > Math.abs(sum1 - sum2) ? i + 1 : answer;

            sum = sum > Math.abs(sum1 - sum2) ? Math.abs(sum1 - sum2) : sum;
        }

        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(4, new int[]{1, 2, 1, 2, 1}), is(2));
    }

    @Test
    public void test2() {
        assertThat(solution(7, new int[]{3, 2, 3, 4, -1, -2, -3}), is(1));
    }
}
