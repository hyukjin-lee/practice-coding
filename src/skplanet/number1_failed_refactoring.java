package skplanet;

import java.util.ArrayList;
import java.util.List;

public class number1_failed_refactoring {

    private List<Integer> result;

    public int solution(List<Integer> integers){
        result = new ArrayList<>();

        findExistResult(integers);
        return result.size();
    }

    private void findExistResult(List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            addToResult(integers, i);
        }
    }

    private void addToResult(List<Integer> integers, int index) {
        if(isInCondition(integers, index)){
            result.add(integers.get(index));
        }
    }

    private boolean isInCondition(List<Integer> integers, int index) {
        return integers.get(index) >= 0 && integers.get(index) < integers.size();
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(4);
        integers.add(-1);
        integers.add(3);
        integers.add(2);
//        System.out.println(solution(integers));
    }
}
