package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class backjoon_15684 {

    private static Scanner scanner = new Scanner(System.in);
    private static int[][] map;
    private static int M, N, H;
    private static List<Position> ladderPositions = new ArrayList<>();

    public static void main(String[] args) {
        int addLadderNumber = 0;
        N = scanner.nextInt();
        M = scanner.nextInt();
        H = scanner.nextInt();

        map = new int[M][N];

        int count = M;

        while (count > 0) {
            int horizontal = scanner.nextInt();
            int vertical = scanner.nextInt();
            ladderPositions.add(new Position(horizontal - 1, vertical - 1));
            count--;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 0;
            }
        }

        for (Position position : ladderPositions) {
            System.out.println(position.x + " " + position.y);
            map[position.x][position.y] = 1;
            map[position.x][position.y + 1] = 2;
        }

        if (N > 2) {
            for (int i = 0; i < N - 1; i++) {
                List<Integer> ladder1Indexs = new ArrayList<>();

                for (int j = 0; j < M; j++) {
                    if (map[j][i] == 1 && map[j][i + 1] == 2) {
                        ladder1Indexs.add(j);
                    }
                }

                if (ladder1Indexs.size() % 2 != 0) {
                    addLadderNumber++;
                }
            }
        } else {
            List<Integer> ladder1Indexs = new ArrayList<>();

            for (int j = 0; j < M; j++) {
                if (map[j][0] == 1 && map[j][1] == 1) {
                    ladder1Indexs.add(j);
                }
            }

            if (ladder1Indexs.size() % 2 != 0) {
                addLadderNumber++;
            }
        }

        if(addLadderNumber >= 0 && addLadderNumber < 4) {
            System.out.println(addLadderNumber);
        } else {
            System.out.println(-1);
        }

    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
