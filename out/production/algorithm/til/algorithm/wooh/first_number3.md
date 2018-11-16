# 코딜리티 문제
> 알고리즘 연습차원에서 코딜리티에서 나온 좌표 문제를 풀어보았습니다.

### 성장 포인트

```java
for (int i = 0; i < integers.size(); i++) {
    for (int j = 0; j < integers.size(); j++) {
        if(i == j) {
            continue;
        }

        for (int k = 0; k < integers.size(); k++) {
            if(k == j || k == i){
                continue;
            }
            for (int l = 0; l < integers.size(); l++) {
                if(k == l || l == j || l == i){
                    continue;
                }
                max = Math.max(max, calculateDistance(integers.get(i),integers.get(j),integers.get(k),integers.get(l)));
            }
        }
    }
}
...
Math.pow(Math.abs(a-c),2) + Math.pow(Math.abs(b-d),2);

```
* 주어진 숫자들을 리스트에 담아서 발생할 수 있는 모든 좌표값을 for문을 활용하여 모두 탐색하였다.

* for문의 depth가 깊어질수록 같은 좌표를 사용하는 일이 없도록 조건이 하나씩 더 생기게 구현하였다.

* Math.pow를 사용하여 제곱을 표현하였고, Math.abs를 사용하여 절대값을 구하였다. 