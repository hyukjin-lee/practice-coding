package algorithm.ka;

import java.util.*;

public class ka2 {

    public int[] solution(int N, int[] users) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> stages = new HashMap<>(); // 해당 스테이지에 위치한 사람 숫자
        Map<Integer, Integer> clearStages = new HashMap<>(); // 해당 스테이지 클리어한 사람 숫자
        Map<Integer, Double> result = new TreeMap<>();

        for (int i = 0; i < users.length; i++) {
            if (stages.containsKey(users[i])) {
                stages.put(users[i], stages.get(users[i]) + 1);
            } else if (!stages.containsKey(users[i])) {
                stages.put(users[i], 1);
            }
        }

        for (int i = N + 1; i >= 1; i--) {
            if (!stages.containsKey(i)) {
                stages.put(i, 0);
            }
            if (i == N + 1 && stages.containsKey(i)) {
                clearStages.put(i, stages.get(i));
            } else if (stages.containsKey(i) && i != N + 1) {
                clearStages.put(i, clearStages.get(i + 1) + stages.get(i));
            }
        }

        for (int i = 1; i <= N; i++) {
            if (clearStages.containsKey(i)) {
                if (clearStages.get(i) != 0) {
                    result.put(i, (double) stages.get(i) / clearStages.get(i));
                } else {
                    result.put(i, 0.0);
                }
            } else {
                result.put(i, 0.0);
            }
        }
        Iterator iterator = sortByValue(result).iterator();
        while (iterator.hasNext()) {
            answer.add((int) iterator.next());
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());


        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);

            }
        });
        return list;
    }

}
