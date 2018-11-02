package skp11;

import java.util.ArrayList;
import java.util.List;

public class number1_failed {

    private static List<Integer> result;

    public static int solution(List<Integer> integers){
        result = new ArrayList<>();

        for (int i = 0; i < integers.size(); i++) {
            if(integers.get(i) >= 0 && integers.get(i) < integers.size()){
                result.add(integers.get(i));
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(4);
        integers.add(-1);
        integers.add(3);
        integers.add(2);
        System.out.println(solution(integers));
    }
}
