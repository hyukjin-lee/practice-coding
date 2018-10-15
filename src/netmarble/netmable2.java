package netmarble;

import java.util.HashMap;
import java.util.Map;

public class netmable2 {
    public long[] solution(String[] words) {
        long[] answer = new long[words.length];
        Map<String, Integer> strings = new HashMap<>();
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if(strings.containsKey(words[i])){
                answer[count++] = strings.get(words[i]);
                continue;
            }else{
                strings.put(words[i], i+1);
                answer[count++] = strings.get(words[i]);
            }
        }

        return answer;
    }
}
