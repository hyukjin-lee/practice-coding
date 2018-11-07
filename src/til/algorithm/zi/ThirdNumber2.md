# 코딜리티 문제
> 알고리즘 연습차원에서 코딜리티에서 나온 Group별 시험 테스트 케이스 통과 확인을 통한 점수 계산 문제를.

### 성장 포인트

```java
 public int solution(String[] T, String[] R) {
         Map<Integer, List<String>> table = new HashMap<>();
         int maxInteger = 0;
         int okGroupCount = 0;
 
         for (int i = 0; i < T.length; i++) {
             T[i] = T[i].replaceAll("[^0-9]", "");
             maxInteger = maxInteger > Integer.parseInt(T[i]) ? maxInteger : Integer.parseInt(T[i]);
 
             if (table.containsKey(Integer.parseInt(T[i]))) {
                 table.get(Integer.parseInt(T[i])).add(R[i]);
             } else {
                 table.put(Integer.parseInt(T[i]), new ArrayList<>());
                 table.get(Integer.parseInt(T[i])).add(R[i]);
             }
         }
 
         for (int i = 1; i <= maxInteger; i++) {
             boolean isOkay = true;
 
             for (String s : table.get(i)) {
                 if (!s.equals("OK")) {
                     isOkay = false;
                     break;
                 }
             }
 
             if(isOkay) {
                 okGroupCount++;
             }
         }
         return (okGroupCount * 100) / maxInteger;
     }
 
     @Test
     public void solutionTest() {
         String[] T = {"sds1","dsds2a", "sdfsd2b"};
         String[] R = {"OK", "OK", "NOT"};
         assertThat(solution(T,R), is(50));
     }
}
```
* `Map<Integer, List<String>>` 맵을 사용하여 한 그룹에 여러 종류의 테스트 결과물을 넣을 수 있도록 하였다.

* 이 문제에서 필요한 것은 각 그룹의 번호이고, 순차적이라고 하였으므로 map에 넣어서 나중에 for문으로 탐색하게 한다.

* map으로 구현하면 key값의 최대를 알기 힘드니까 maxInteger를 두고 값을 넣을 때 마다 maxInt값을 기록한다.

* 테스트를 통과하지 못한 것이 한개라도 있으면 무조건 0점이므로 OK인지만 확인해서 거르면 된다.
