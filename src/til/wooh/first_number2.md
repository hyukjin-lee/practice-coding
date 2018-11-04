# 코딜리티 문제
> 알고리즘 연습차원에서 코딜리티에서 나온 카드게임 문제를 풀어보았습니다.

### 성장 포인트

```java
map.put('2', 2);
map.put('3', 3);
map.put('4', 4);
map.put('5', 5);
map.put('6', 6);
map.put('7', 7);
map.put('8', 8);
map.put('9', 9);
map.put('T', 10);
map.put('J', 11);
map.put('Q', 12);
map.put('K', 13);
map.put('A', 14);

alex.valueOf(i)
alex.charAt(i)   
```
* 카드게임처럼 숫자, 문자로 점수의 높낮이를 계산하는 곳에 map이 아주 적당할 것 같아서 map을 썼다. 

* 덕분에 문자열 탐색할 때 걸리는 O(n) 말고 추가적인 시간복잡도가 발생하지 않았다.

* valueOf() 함수를 그동안 오해하고 있었다. valueOf는 String의 static 함수다. 즉 내가 지금 동적으로 할당한 객체에 대한 함수가 아니라, 공용으로 사용하는 것이란 뜻이다. valueOf의 파라미터에 Integer 값을 넣으면 그것이 String으로 변환되어 나오는 것이지, index에 해당하는 문자가 추출되는 것이 아니다. 즉 상태값과 관련이 없고 기능 로직만 수행한다. 해당 String 객체의 index에 접근하고 싶다면 charAt을 하여 Character 형으로 추출하면 된다. 