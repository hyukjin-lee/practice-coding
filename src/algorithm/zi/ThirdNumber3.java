package algorithm.zi;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ThirdNumber3 {
    public int solution(int[] A, int K, int L) {
        if (A.length < K + L) return -1;

        // apple_alice : 배열 A에서 K개 씩 묶은 합을 리스트로 저장
        // 용도 : 겹치는지 검사할 때 인덱스 참고할 것임
        List<Integer> apple_alice = getApplesList(A, K);
        List<Integer> apple_bob = getApplesList(A, L);
        //sorted_alice : 위 리스트를 내림차순 정렬한 것을 큐에 저장
        // 용도 : 최대값 하나씩 빼올것임
        Queue<Integer> sorted_alice = toSortedQueue(apple_alice);
        Queue<Integer> sorted_bob = toSortedQueue(apple_bob);

        // max_alice : K개 씩 묶은 합 중에서 최대값을 차례차례 저장할 변수
        int max_alice = sorted_alice.poll();
        int max_bob = sorted_bob.poll();
        // maxIndex_alice : apple_alice 리스트에서 max_alice가 있는 인덱스
        int maxIndex_alice = Collections.binarySearch(apple_alice, max_alice);
        int maxIndex_bob = Collections.binarySearch(apple_bob, max_bob);

        // 서로 안 겹칠 때 까지 큐에서 값 하나씩 뺌
        while (isOverlap(maxIndex_alice, maxIndex_bob, K, L)) {
            // diff_alice : 현재 최대값과 그 다음 최대값의 차이를 구함.
            int diff_alice = getDiff(sorted_alice, max_alice);
            int diff_bob = getDiff(sorted_bob, max_bob);

            //diff가 더 작은 아이의 최대값 교체
            if (diff_alice < diff_bob) {
                max_alice = sorted_alice.poll();
                maxIndex_alice = Collections.binarySearch(apple_alice, max_alice);
            } else if (diff_alice > diff_bob) {
                max_bob = sorted_bob.poll();
                maxIndex_bob = Collections.binarySearch(apple_bob, max_bob);
            } else { // diff_alice == diff_bob일 경우.
                //큐가 비어있지 않으면 아무나 최대값 교체
                if (!sorted_alice.isEmpty()) {
                    max_alice = sorted_alice.poll();
                    maxIndex_alice = Collections.binarySearch(apple_alice, max_alice);
                } else if (!sorted_bob.isEmpty()) {
                    max_bob = sorted_bob.poll();
                    maxIndex_bob = Collections.binarySearch(apple_bob, max_bob);
                }
                else { // 큐가 모두 비어있다 = 모든 값이 겹친다. 그러나 이럴 경우는 함수 맨 위에서 다 걸러질 듯.
                    return -1;
                }
            }
        }

        return max_alice + max_bob;
    }

    public int getDiff(Queue<Integer> queue, int a) {
        if (!queue.isEmpty()) return a - queue.element();
        return Integer.MAX_VALUE;
    }

    public static Queue<Integer> toSortedQueue(List<Integer> list) {
        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        Collections.sort(temp);
        Collections.reverse(temp);

        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(temp);

        return queue;
    }

    public boolean isOverlap(int maxIndex_alice, int maxIndex_bob, int K, int L) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < K; i++) {
            set.add(i + maxIndex_alice);
        }
        for (int i = 0; i < L; i++) {
            set.add(i + maxIndex_bob);
        }
        if (set.size() == K + L) return false;
        return true;
    }

    public List<Integer> getApplesList(int[] A, int tree) {
        List<Integer> applesList = new ArrayList<>();

        for (int i = 0; i <= A.length - tree; i++) {
            int sum = 0;
            for (int j = 0; j < tree; j++) {
                sum += A[i + j];
            }
            applesList.add(sum);
        }
        return applesList;
    }

    @Test
    public void test() {
        int[] A = {6, 1, 4, 6, 3, 2, 7, 4};
        int[] B = {10, 19, 15};
        Assert.assertEquals(solution(A, 3, 2), 24);
        Assert.assertEquals(solution(B, 2, 2), -1);
    }
}