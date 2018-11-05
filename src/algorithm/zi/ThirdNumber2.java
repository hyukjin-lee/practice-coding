package algorithm.zi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThirdNumber2 {
    public int solution(String[] T, String[] R) {
        Map<Integer, List<String>> table = new HashMap<>();
        int maxInteger = 0;
        int okGroupCount = 0;

        for (int i = 0; i < T.length; i++) {
            T[i] = T[i].replaceAll("[^0-9]", "");
            maxInteger = maxInteger > Integer.parseInt(T[i]) ? maxInteger : Integer.parseInt(T[i]);

            if (table.containsKey(Integer.parseInt(T[i]))) {
                table.get(Integer.parseInt(T[i])).add(R[i]);
            } else {
                table.put(Integer.parseInt(T[i]), new ArrayList<>());
                table.get(Integer.parseInt(T[i])).add(R[i]);
            }
        }

        for (int i = 1; i <= maxInteger; i++) {
            boolean isOkay = true;

            for (String s : table.get(i)) {
                if (!s.equals("OK")) {
                    isOkay = false;
                    break;
                }
            }

            if(isOkay) {
                okGroupCount++;
            }
        }
        return (okGroupCount * 100) / maxInteger;
    }

    @Test
    public void solutionTest() {
        String[] T = {"sds1","dsds2a", "sdfsd2b"};
        String[] R = {"OK", "OK", "NOT"};
        assertThat(solution(T,R), is(100));
    }
}
