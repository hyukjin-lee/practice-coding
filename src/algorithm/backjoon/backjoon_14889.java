package algorithm.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_14889 {

    private static int[][] map;
    private static int[] team;
    private static int N;
    private static int answer = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[21][21];
        team = new int[21];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dfs(1);

        System.out.println(answer);
    }

    public static void dfs(int index) {

        if (index == N + 1) {
            int answer1 = 0;
            int answer2 = 0;

            int count1 = 0;
            int count2 = 0;

            for (int i = 1; i <= N; i++) {
                if (team[i] == 1) {
                    count1++;
                } else if (team[i] == 2) {
                    count2++;
                }
            }

            if (count1 != count2) {
                return;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (team[i] == 1 && team[j] == 1) {
                        answer1 += map[i][j];
                    } else if (team[i] == 2 && team[j] == 2) {
                        answer2 += map[i][j];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(answer1 - answer2));
            return;
        }

        team[index] = 1;
        dfs(index + 1);

        team[index] = 2;
        dfs(index + 1);
    }
}
