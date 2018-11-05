package algorithm.zi;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThirdNumber1 {
    public int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    for (int k = 1; k <= 6; k++) {
                        if (A[i] == k) {
                            if (A[j] == k) {
                                continue;
                            } else if (A[j] == 7-k) {
                                count = count + 2;
                            } else {
                                count++;
                            }
                        }
                    }
                }
            }
            min = min > count ? count : min;
        }
        return min;
    }

    @Test
    public void solutionTest() {
        int[] input = {1,2,3};
        assertThat(solution(input), is(2));
    }

    @Test
    public void solutionTest2() {
        int[] input = {1,1,6};
        assertThat(solution(input), is(2));
    }

    @Test
    public void solutionTest3() {
        int[] input = {1,6,2,3};
        assertThat(solution(input), is(3));
    }
}
