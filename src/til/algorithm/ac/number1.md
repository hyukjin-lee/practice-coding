# 배열 이등분 차이 문제
> 알고리즘 연습차원에서 배열 이등분 차이 최소 원소 개수 반환 문제를 풀어보았습니다.

### 성장 포인트

```java
public int solution(int n, int[] v) {
        int answer = 0;
        int sum = 0;
        int sum1 = 0;
        int sum2;

        for (int i = 0; i < n; i++) {
            sum += v[i];
        }

        sum2 = sum;
        sum = Math.abs(sum);

        for (int i = 0; i < n; i++) {
            sum2 -= v[i];
            sum1 += v[i];

            answer = sum > Math.abs(sum1 - sum2) ? i + 1 : answer;

            sum = sum > Math.abs(sum1 - sum2) ? Math.abs(sum1 - sum2) : sum;
        }

        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(4, new int[]{1, 2, 1, 2, 1}), is(2));
    }

    @Test
    public void test2() {
        assertThat(solution(7, new int[]{3, 2, 3, 4, -1, -2, -3}), is(1));
    }     
```
* 왼쪽을 기준으로 원소개수 최소값을 구하는 문제인줄 모르고 왼쪽 오른쪽 비교해서 최소값을 구하는 로직을 짜서 실패가 중간중간 떴다.

* 처음에는 for문을 돌면서 원소하나를 선택하고, 그 원소를 기준으로 다시 for문을 돌면서 왼쪽의 합, 오른쪽의 합을 구해서 차이값을 구했다.

* 하지만 효율성 검증에서 계속 오류가 났고, O(N)으로 줄여야했다. 그래서 처음 for문을 돌 때 합을 세팅해두고, 그 다음 원소 도는 for문을 돌 때 이미 구해놓은 왼쪽 sum과 오른쪽 sum에서 더하고 빼기만 하면 for문을 굳이 돌지 않아도 된다.

* 친구에게 자문을 구해서 이러한 효율성 로직을 알게되었고, 앞으로도 많이 써먹을 일이 있을 것 같다. 