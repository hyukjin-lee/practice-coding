package skp11;

import java.util.ArrayList;
import java.util.List;

public class number2 {

    private List<String> result;

    public int solution(String input) {
        String sentences[] = input.split("\\?|!|\\.");

        return findMaxWordsSentence(sentences);
    }

    private int findMaxWordsSentence(String[] sentences) {
        int max = 0;

        for (int i = 0; i < sentences.length; i++) {
            String words[] = sentences[i].split(" ");
            result = new ArrayList<>();

            addWordsToResult(words);

            max = calculateMax(max);
        }
        return max;
    }

    private void addWordsToResult(String[] words) {
        for (int j = 0; j < words.length; j++) {
            addNotEmptyWord(words[j]);
        }
    }

    private void addNotEmptyWord(String word) {
        if(!word.isEmpty()) {
            result.add(word);
        }
    }

    private int calculateMax(int max) {
        max = max < result.size() ? result.size() : max;
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(solution("Forget VCS??Save time ! x x x"));
    }
}
