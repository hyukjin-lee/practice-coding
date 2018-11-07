# 백준 1652번 누울 자리를 찾아라
> 방의 크기 N과 방의 구조가 주어졌을 때, 가로로 누울 수 있는 자리와 세로로 누울 수 있는 자리의 수를 구하는 프로그램을 작성하는 문제입니다.

### 성장 포인트

```java
Queue<Character> queue = new LinkedList<>();
...
queue.removeAll(queue);
```
* map[][] 배열에 지도를 넣어두고, Queue를 통해서 .의 갯수를 파악한다. X가 들어오면 Queue size를 세고, queue.removeAll을 써서 큐를 초기화 시킨다.

* Queue와 stack은 컬렉션 프레임워크의 FIFO, LIFO 자료구조를 대표한다. Queue는 priority Queue, priorityBlockingQueue, LinkedList가 있다.

* priorityQueue는 PIPO다. null 요소를 허용하지 않는다.

* priorityBlockingQueue는 동기화를 메소드를 보유한다. null 요소를 허용하지 않는다. priorityQueue에 비해 느리다.

* LinkedList는 끝에 추가가 용이하다. List 인터페이스를 구현. 요소에 null을 허용한다.

* 스택(Stack)을 응용한 대표적인 예가 JVM 스택 메모리입니다. 스택 메모리에 저장된 변수는 나중에 저장된 것부터 제거됩니다.
 
* 큐(Queue)를 응용한 대표적인 예가 스레드풀(ExecutorService)의 작업 큐입니다. 작업 큐는 먼저 들어온 작업부터 처리합니다.
 
 
 
 