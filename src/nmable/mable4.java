package nmable;

public class mable4 {
    public int solution(int[] estimates, int k) {
        int answer = 0;

        for (int i = 0; i < estimates.length - k+1; i++) {
            int current = 0;
            for (int j = i; j < i + k; j++) {
                current += estimates[j];
            }
            if (answer == current) {
                continue;
            }
            answer = current > answer ? current : answer;
        }
        return answer;
    }
}
