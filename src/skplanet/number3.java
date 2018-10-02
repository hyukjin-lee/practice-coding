package skplanet;

import java.util.ArrayList;
import java.util.List;

public class number3 {

    public int solution(int[] coins) {
        int head = 0;
        int tail = 0;

        for (int coin : coins) {
            if (coin == 0) {
                head++;
            } else {
                tail++;
            }
        }

        return findMinimumCase(head, tail);
    }

    private int findMinimumCase(int head, int tail) {
        if(head > tail) {
            return tail;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(0);
        coins.add(0);
        coins.add(0);
        coins.add(1);
        coins.add(1);
//        System.out.println(solution(coins));
    }
}
