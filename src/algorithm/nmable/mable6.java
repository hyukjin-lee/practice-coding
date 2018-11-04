package algorithm.nmable;

public class mable6 {
    static int sum = 0;
    public static int solution(int n) {
        return flowOfDragonLife(0, 0, 1, n);
    }

    private static int flowOfDragonLife(int eggDragonCount, int deadDragonCount, int eggCount, int expireDay) {
        for (int i = 0; i <= expireDay; i++) {
            if (i == 6) {
                deadDragonCount++;
                eggDragonCount--;

            }

            if (i == 2) {
                eggCount--;
                eggDragonCount++;
            }

            if (i >= 2 && i < 6) {
                eggCount++;
                sum += flowOfDragonLife(eggDragonCount, deadDragonCount, eggCount, expireDay);

            }

            if (expireDay == i) {
                return eggCount;
            }
        }

        return eggCount;
    }

    public static void main(String[] args) {
        System.out.println(solution(6));
    }
}


// 알에서 부화한 경우  알-1  egg드래곤 +1
// egg드래곤이 부화한지 +4일째에는 egg드래곤 -1 dead드래곤 +1
// egg드래곤이 알을 낳을 수 있는 기간 thisDragonDay가 2~6일차에 매일 eggcount+1
//