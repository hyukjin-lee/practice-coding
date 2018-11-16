package algorithm.ac;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class number3 {
    public int solution(int n, int maxhp, int[] times, int[] effects) {
        int answer = 0;
        int effectSum = 0;
        int currentHp = 0;
        int timeCount = 0;

        for (int i = 0; i <= times[times.length - 1]; i++) {

            if (i == times[timeCount]) {
                currentHp += effectSum;

                if (currentHp > maxhp) {
                    currentHp = maxhp;
                } else if (currentHp < 0) {
                    currentHp = 0;
                }

                effectSum += effects[timeCount];
                timeCount++;
            } else {
                currentHp += effectSum;

                if (currentHp > maxhp) {
                    currentHp = maxhp;
                } else if (currentHp < 0) {
                    currentHp = 0;
                }
            }

            if (currentHp == 0 || currentHp == maxhp) {
                answer++;
            }

        }

        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(5, 10, new int[]{1, 5, 7, 10, 11}, new int[]{4, -6, -1, 4, 1}), is(6));
    }
}
