package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class backjoon_15683_Samsung {

    static int map[][];
    static int answer = 0;

    static List<Point> points = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    static int globalY = scanner.nextInt();
    static int globalX = scanner.nextInt();

    public static void main(String[] args) {
        map = new int[globalY][globalX];

        for (int i = 0; i < globalY; i++) {
            for (int j = 0; j < globalX; j++) {
                map[i][j] = scanner.nextInt();

                if (map[i][j] > 0 && map[i][j] != 6) {
                    points.add(new Point(j, i));
                }

                if (map[i][j] == 0) {
                    answer++;
                }
            }
        }
        search(map, 0);
        System.out.println(answer);
    }

    public static void search(int[][] resultMap, int pointsIndex) {
        int[][] visited = new int[globalY][globalX];
        int thisAnswer = 0;
        if (pointsIndex == points.size()) {
            for (int i = 0; i < globalY; i++) {
                for (int j = 0; j < globalX; j++) {
                    if (resultMap[i][j] == 0) {
                        thisAnswer++;
                    }
                }
            }
            if (thisAnswer < answer) {
                answer = thisAnswer;
            }
            return;
        } else {
            int x = points.get(pointsIndex).x;
            int y = points.get(pointsIndex).y;
            switch (map[y][x]) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < globalY; j++) {
                            for (int k = 0; k < globalX; k++) {
                                visited[j][k] = resultMap[j][k];
                            }
                        }
                        visitPoint(visited, x, y, i);
                        search(visited, pointsIndex + 1);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < globalY; j++) {
                            for (int k = 0; k < globalX; k++) {
                                visited[j][k] = resultMap[j][k];
                            }
                        }
                        visitPoint(visited, x, y, i);
                        visitPoint(visited, x, y, i + 2);
                        search(visited, pointsIndex + 1);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < globalY; j++) {
                            for (int k = 0; k < globalX; k++) {
                                visited[j][k] = resultMap[j][k];
                            }
                        }
                        visitPoint(visited, x, y, i);
                        visitPoint(visited, x, y, (i + 1) % 4);
                        search(visited, pointsIndex + 1);
                    }
                    break;
                case 4:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < globalY; j++) {
                            for (int k = 0; k < globalX; k++) {
                                visited[j][k] = resultMap[j][k];
                            }
                        }
                        visitPoint(visited, x, y, i);
                        visitPoint(visited, x, y, (i + 1) % 4);
                        visitPoint(visited, x, y, (i + 2) % 4);
                        search(visited, pointsIndex + 1);
                    }
                    break;
                case 5:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < globalY; j++) {
                            for (int k = 0; k < globalX; k++) {
                                visited[j][k] = resultMap[j][k];
                            }
                        }
                        visitPoint(visited, x, y, 0);
                        visitPoint(visited, x, y, 1);
                        visitPoint(visited, x, y, 2);
                        visitPoint(visited, x, y, 3);
                        search(visited, pointsIndex + 1);
                    }
                    break;
            }
        }
    }

    public static void visitPoint(int[][] resultMap, int x, int y, int direction) {
        switch (direction) {
            case 0:
                for (int i = x; i < globalX; i++) {
                    if (resultMap[y][i] == 6) {
                        break;
                    } else {
                        resultMap[y][i] = 8;
                    }
                }
                break;
            case 1:
                for (int i = y; i < globalY; i++) {
                    if (resultMap[i][x] == 6) {
                        break;
                    } else {
                        resultMap[i][x] = 8;
                    }
                }
                break;
            case 2:
                for (int i = x; i >= 0; i--) {
                    if (resultMap[y][i] == 6) {
                        break;
                    } else {
                        resultMap[y][i] = 8;
                    }
                }
                break;
            case 3:
                for (int i = y; i >= 0; i--) {
                    if (resultMap[i][x] == 6) {
                        break;
                    } else {
                        resultMap[i][x] = 8;
                    }
                }
                break;

        }
    }

    public static class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
}
