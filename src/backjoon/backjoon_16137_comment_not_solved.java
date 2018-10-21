package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_16137_comment_not_solved {

    static int map[][];
    static boolean roadPossibleMap[][];
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int m;

    private static void checkValidation(Point point, int time, boolean isHuddle) {
        System.out.println("time : " + time);
        System.out.println("Point : " + point.x + " " + point.y);

        if (point.x < 0 || point.y < 0 || point.x >= n || point.y >= n) {     // 좌표계 벗어난 경우 체크
            System.out.println("out of range");
            return;
        }

        if (point.x == n - 1 && point.y == n - 1) {
            answer = Math.min(time, answer);
            System.out.println("finished");
            return;
        }

        if(time == 0) {
            dfs(point, time, isHuddle);
        }


        if (roadPossibleMap[point.y][point.x] == false) {                   // 절벽과 만났을 때
            int count = 0;
            isHuddle = true;
            for (int i = -1; i <= 1; i = i + 2) {
                for (int j = -1; j <= 1; j = j + 2) {
                    if (point.y + i >= n || point.x + j >= n || point.y + i < 0 || point.x + j < 0) {
                        continue;
                    }

                    if (roadPossibleMap[point.y + i][point.x + j] == false) {
                        count++;
                    }
                }
            }
            if (count >= 3) {                               // 3방향 이상 겹치면 오작교 설치 불가능
                System.out.println("3 way == 1");
                return;
            } else {
                System.out.println("setting : m");
                if(map[point.y][point.x] == 0) {
                    map[point.y][point.x] = m;
                }
            }

            int numCount = 0;

            //2방향 이상 오작교 설치 불가능
            if (point.y + 1 >= n || point.x + 1 >= n || point.y - 1 < 0 || point.x - 1 < 0) {

            } else {
                for (int i = -1; i <= 1; i=i+2) {
                    if (map[point.y + i][point.x] == 0) {
                        for (int j = -1; j <= 1; j = j + 2) {
                            if (map[point.y][point.x + j] == 0) {
                                numCount++;
                            }
                        }
                        if (numCount == 2) {
                            System.out.println("two way == 0");
                            return;
                        }
                    }
                }
            }

            if(map[point.y][point.x] > 1) {
                int randomM = map[point.y][point.x];
                if (time % randomM != 0) {                            // 문 열렸는지 체크
                    System.out.println("time % random : " + time % m);
                    System.out.println("it's no time");
                    System.out.println();
                    checkValidation(new Point(point.x, point.y), time / randomM > 0 ? randomM * (time/randomM + 1) : randomM, true);
                    return;
                }
            } else if(map[point.y][point.x] == 0){
                if (time % m != 0) {                            // 문 열렸는지 체크
                    System.out.println("time % m : " + time % m);
                    System.out.println("it's no time");
                    System.out.println();
                    checkValidation(new Point(point.x, point.y), time / m > 0 ? m * (time/m + 1) : m, true);
                    return;
                }
            }
        } else {
            isHuddle = false;
        }
        if(time != 0) {
            System.out.println("time4?");
            dfs(point, time, isHuddle);
        }
    }

    private static void dfs(Point point, int time, boolean wasHuddle) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                if (point.y + i >= n || point.x + j >= n || point.y + i < 0 || point.x + j < 0) {
                    continue;
                }
                if (roadPossibleMap[point.y+i][point.x+j] == false && wasHuddle == true) {
                    continue;
                }
                if (j == 0 && i == 0) {
                    continue;
                }
                if (j == 1 && i == 1) {
                    continue;
                }
                System.out.println();
                checkValidation(new Point(point.x + j, point.y + i), time + 1, false);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];
        roadPossibleMap = new boolean[10][10];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(map[i][j] == 0 || map[i][j] > 1){
                    roadPossibleMap[i][j] = false;
                } else {
                    roadPossibleMap[i][j] = true;
                }
            }
        }

        checkValidation(new Point(0, 0), 0, false);
        System.out.println(answer);
    }

    public static class Point {
        public int y, x;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
