package algorithm.zinter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SecondNumber4 {

    public int solution(String input) {
        Map<Character, Integer> alphabets = new HashMap<>();
        int count = 0;

        // 요구사항에 Alphabet 대문자로 한정해놓았으므로 Map으로 셋팅하여 사용하면 시간복잡도를 줄일 수 있다.
        for (int i = 65; i <= 90; i++) {
            alphabets.put((char) i, 0);
        }

        for (int i = 0; i < input.length(); i++) {
            List<Character> characters = new ArrayList<>();

            characters.add(input.charAt(i)); // 첫 글자는 바깥쪽 For문에서 넣는다.
            alphabets.put(input.charAt(i), alphabets.get(input.charAt(i)) + 1);
            count++;

            for (int j = i + 1; j < input.length(); j++) {
                characters.add(input.charAt(j));
                alphabets.put(input.charAt(j), alphabets.get(input.charAt(j)) + 1);

                for (int k = 65; k <= 90; k++) {
                    if(alphabets.get((char) k) == 1) {
                        count++;
                    }
                }
            }

            //Map 초기화
            for (int u = 65; u <= 90; u++) {
                alphabets.put((char) u, 0);
            }
        }

        return count;
    }

    @Test
    public void solutionTest() {
        assertThat(solution("CODILITY"), is(96));
    }

    @Test
    public void solutionTest2() {
        assertThat(solution("ACAX"), is(16));
    }
}
