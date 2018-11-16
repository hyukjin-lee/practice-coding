# 코딜리티 문제
> 알고리즘 연습차원에서 코딜리티에서 나온 주사위 정육면체 문제를 풀어보았습니다.

### 성장 포인트

```java
 public int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    for (int k = 1; k <= 6; k++) {
                        if (A[i] == k) {
                            if (A[j] == k) {
                                continue;
                            } else if (A[j] == 7-k) {
                                count = count + 2;
                            } else {
                                count++;
                            }
                        }
                    }
                }
            }
            min = min > count ? count : min;
        }
        return min;
    }

    @Test
    public void solutionTest() {
        int[] input = {1,2,3};
        assertThat(solution(input), is(2));
    }

    @Test
    public void solutionTest2() {
        int[] input = {1,1,6};
        assertThat(solution(input), is(2));
    }

    @Test
    public void solutionTest3() {
        int[] input = {1,6,2,3};
        assertThat(solution(input), is(3));
    }    
```
* 주사위는 마주보는 면의 합이 7이고, 이 게임에서는 던져진 각 주사위들을 한 면씩 굴려서 모두 같은 면이 나오게 하는 최소값을 출력하는 문제다. 

* 각 주사위를 순위하면서 지금 현재 인덱스의 주사위로 나머지 주사위들의 숫자들이 맞춰지면 count가 얼마나 나올까로 접근했다. 그리고 그 count를 max와 비교하여 집어넣는 방식의 코딩을 했다.

* 보통 문제를 풀다보면 함수만 써서 제출하는 형태의 요구사항이 있는데, IDE로 작업하다보면 Main을 만들어야 테스트가 가능해서 그동안 매우 비효율적인 작업을 했다. 하지만 같은 클래스에 `@Test` JUnit을 사용하여 테스트코드를 작성해서 하면 비효율적인 방식이 줄어들게 된다. 

* 문제의 요구사항을 잘 파악하자. 주사위 숫자의 합이 7일때를 이용하면 모든 경우를 For문으로 묶어낼 수 있다.