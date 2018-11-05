package algorithm.zi;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SecondNumber1 {

    public int solution(int a, int b) {
        int max = 0;

        for (int i = a; i <= b; i++) {
            max = max < square(i, 0) ? square(i, 0) : max;
        }

        return max;
    }

    private int square(int number, int count) {
        int squaredNumber = (int) Math.sqrt(number);

        while (squaredNumber * squaredNumber == number) {
            number = squaredNumber;
            squaredNumber = (int) Math.sqrt(number);
            count++;
        }

        return count;
    }

    @Test
    public void solutionTest() {
        assertThat(solution(6000,7000), is(3));
    }

    @Test
    public void squareTest() {
        assertThat(square(16, 0), is(2));
    }
}
