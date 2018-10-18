package line;

import java.util.*;

public class LineAlgorithm1_summer {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Point, String> scoreBoards = new TreeMap<Point, String>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.distance > o2.distance) {
                return 1;
            } else if (o1.distance == o2.distance) {
                return 0;
            } else {
                return -1;
            }
        }
    });

    public static void main(String[] args) {
        int gameSet = scanner.nextInt();

        while (gameSet > 0) {
            setGameInput();
            System.out.println(gamePlay());
            gameSet--;
        }
    }

    private static void setGameInput() {
        int stoneNumber = scanner.nextInt();

        while (stoneNumber > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String playerName = scanner.nextLine();

            scoreBoards.put(new Point(x, y), playerName);
            stoneNumber--;
        }
    }

    private static String gamePlay() {
        int winningScore = 0;
        int count = 0;
        boolean loserFlag = false;

        Map.Entry<Point, String> loser = null;
        Map.Entry<Point, String> winner = null;

        for (Map.Entry<Point, String> entry : scoreBoards.entrySet()) {
            if (count == 0) {
                winner = entry;
                winningScore++;
                count++;
                continue;
            }

            if (count != 0 && winner.getValue().equals(entry.getValue()) && loserFlag == false) {
                winningScore++;
                continue;
            }

            if (count != 0 && !winner.getValue().equals(entry.getValue()) && loserFlag == false) {
                loserFlag = true;
                loser = entry;
                break;
            }

        }
        return winner.getValue() + " : " + winningScore;
    }

    public static class Point {

        int x, y;
        double distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt((Math.pow(x, 2)) + Math.pow(y, 2));
        }

        public double getDistance() {
            return distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y &&
                    Double.compare(point.distance, distance) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, distance);
        }
    }

}