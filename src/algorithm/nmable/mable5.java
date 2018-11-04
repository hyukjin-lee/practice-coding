package algorithm.nmable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mable5 {
    public static int solution(int[] stats) {
        int roomCount = 0;
        Map<Integer, List<Integer>> teams = new HashMap<>();

        for (int i = 0; i < stats.length; i++) {
            System.out.println("fuck : "+ stats[i]);
            boolean isNewTeam = true;
            System.out.println(teams.toString());
            if (roomCount == 0) {
                List<Integer> team = new ArrayList<>();
                team.add(stats[i]);

                teams.put(0, team);
                roomCount++;
                continue;
            }
            for (int j = 0; j < roomCount; j++) {
                List<Integer> current = teams.get(j);
                boolean isAllUnderNumber = false;
                int roomMaxNumber = 0;
                for (Integer integer : current) {
                    if(integer > stats[i]) {
                        isAllUnderNumber = false;
                        break;
                    }
                    isAllUnderNumber = true;
                }
                if(isAllUnderNumber){
                    current.add(stats[i]);
                    teams.put(j,current);
                    isNewTeam = false;
                    break;
                }
            }

            if(isNewTeam) {
                List<Integer> team = new ArrayList<>();
                team.add(stats[i]);
                teams.put(roomCount, team);
                roomCount++;
                continue;
            }

        }
        return roomCount;
    }

    public static void main(String[] args) {
        int stats[] = {12,1,2,3,43,88,64,56};
        System.out.println(solution(stats));
    }
}
