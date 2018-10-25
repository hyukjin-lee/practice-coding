# 백준 1747번 소수 & 펠린드롬
> 숫자 N 이상이면서 소수를 만족하고 동시에 펠린드롬을 만족하는 숫자를 찾는 문제입니다.

### 성장 포인트

```java
boolean isPrimeNumber = true;

    for (int i = 2; i < number; i++) {
        if (number % i == 0) {
            isPrimeNumber = false;
            break;
        }
    }
...
   
String numberString = String.valueOf(number);
...

List<Integer> newIntegers = new ArrayList<>();
newIntegers.addAll(integers);
...

Collections.reverse(newIntegers);

```
* 처음에 isPrimeNumber를 false로 기본값을 두고, number % i != 0 일 때 isPrimeNumber를 True로 바꾸는 로직으로 짰었다. 문제점은 number % i != 0 인 당연히 많고 내가 찾는 것은 For문을 돌면서 isPrimeNumber로서의 조건을 무결하게 만족하는지였다. 요구사항 조건을 명확히해야 이런 실수가 안나오겠다는 생각을 해보았다.

* String.valueOf를 사용하면 char든 int든 뭐든 간에 String 형태로 형변환 할 수 있다. 처음에는 new String으로 초기화 시키려했으나 불가능했다. String에서도 여러 static 함수들을 제공하니 잘 사용하면 유용할 것 같다.

* 깊은 복사와 얕은 복사를 공부하였다. 자바는 객체가 Reference 기반이어서 주소를 가리킨다. 처음에 newInteger = integers 로 복사하고 reverse를 시켰더니 integers도 역순으로 정렬되어버렸다. 이것은 깊은 복사를 했기 때문에 integers도 똑같은 메모리를 가리키고 있어서이다. 얕은 복사를 하기 위해서는 값들만 복사해서 새로운 메모리 공간에 할당해야하는데, List를 그렇게 많이 사용해왔음에도 불구하고 addAll 이라는 것을 처음 사용해봤다. 해당 List의 내용을 모두 복사하여 새 리스트에 add 시켜주는 역할을 한다.

* Collections 클래스에서는 내가 모르는 여러 유용한 기능들이 있다. 처음에 Stream을 사용하여 sorted로 Comparator.reverseOrder를 하였지만, 생각해보니 이것은 오름차순 내림차순 정렬을 할 때 사용하는 것이고, 지금 내가 하고 싶은 것은 리스트 index 순서를 역순으로 바꾸는 것이었다. 그래서 알아본 결과 Collections.reverse() 라는 함수가 있었고, 이것은 Collection 객체들의 순서를 뒤집어주는 역할을 한다. 매우 유용하다.  
