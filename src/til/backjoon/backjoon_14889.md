# 백준 14889번 스타트 링크
> 삼성 역량테스트 대비할겸 기출문제를 풀어보았습니다. DFS로 해결하였습니다.

### 성장 포인트

```java
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
for (int i = 1; i <= N; i++) {
     StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
     for (int j = 1; j <= N; j++) {
         map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
     }
 }         
```
* Scanner를 주로 사용했었는데, Coding Test를 보는 곳 마다 기본 뼈대 코드로 BufferedReader를 사용하여 이번 기회에 익혀보려고 써봤다.
BufferedReader는 수가 커질수록 Scanner와의 속도 차이가 유의미하게 발생한다. 나중에 시간 초과가 난다면 Scanner 문제일 수도 있으니 애초부터 BufferedReader를 사용하는 것이 낫겠다.

* 속도 차이의 원인은 Scanner가 편리한 기능을 제공해주는 대신 내부적으로 수많은 Regex를 거쳐야하기 때문에 굳이 꼭 필요없는 작업에 대한 시간이 소요되기 때문이다.

* BufferedReader는 buffer 형태로 읽어오기 때문에 모든 값을 문자열 형태로 읽는다. 이번에 처음 알게되었다. Integer로 parseInt 하려고 했는데, 
이번엔 띄어쓰기까지 read 되어서 -값이 들어가게 되었다. 

*  이러한 이유 때문에 StringTokenizer를 사용하여 한글자씩 int로 변환한다는 것을 몸소 체험하게 되었다.
 
*  DFS는 team1 team2 가 될 수 있는 모든 가짓수를 알기 위해 썼으며, 숫자가 반으로 안나눠지는 경우들이 포함되어있어서 for if로 비교하여 예외처리 하였다.
