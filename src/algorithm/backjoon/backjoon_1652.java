package algorithm.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class backjoon_1652 {

    static Queue<Character> queue = new LinkedList<>();
    static char map[][];
    static int countVertical = 0;
    static int countHorizontal = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();

            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //가로 체크
        for (int i = 0; i < n; i++) {
            int size = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    queue.add(map[i][j]);
                    continue;
                } else if (map[i][j] == 'X') {
                    if (queue.size() >= 2) {
                        countHorizontal++;
                    }
                    queue.removeAll(queue);
                }
            }
            if (queue.size() >= 2) {
                countHorizontal++;
            }
            queue.removeAll(queue);
        }


        //세로 체크
        for (int j = 0; j < n; j++) {
            int size = 0;
            for (int i = 0; i < n; i++) {
                if (map[i][j] == '.') {
                    queue.add(map[i][j]);
                    continue;
                } else if (map[i][j] == 'X') {
                    if (queue.size() >= 2) {
                        countVertical++;
                    }
                    queue.removeAll(queue);
                }
            }
            if (queue.size() >= 2) {
                countVertical++;
            }
            queue.removeAll(queue);
        }

        System.out.print(countHorizontal);
        System.out.print(" ");
        System.out.print(countVertical);
    }
}
