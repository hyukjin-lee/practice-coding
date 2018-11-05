# 코딜리티 문제
> 알고리즘 연습차원에서 코딜리티에서 나온 문자열 문제를 풀어보았습니다.

### 성장 포인트

```java
public int solution(String input) {
        Map<Character, Integer> alphabets = new HashMap<>();
        int count = 0;

        // 요구사항에 Alphabet 대문자로 한정해놓았으므로 Map으로 셋팅하여 사용하면 시간복잡도를 줄일 수 있다.
        for (int i = 65; i <= 90; i++) {
            alphabets.put((char) i, 0);
        }

        for (int i = 0; i < input.length(); i++) {
            List<Character> characters = new ArrayList<>();

            characters.add(input.charAt(i)); // 첫 글자는 바깥쪽 For문에서 넣는다.
            alphabets.put(input.charAt(i), alphabets.get(input.charAt(i)) + 1);
            count++;

            for (int j = i + 1; j < input.length(); j++) {
                characters.add(input.charAt(j));
                alphabets.put(input.charAt(j), alphabets.get(input.charAt(j)) + 1);

                for (int k = 65; k <= 90; k++) {
                    if(alphabets.get((char) k) == 1) {
                        count++;
                    }
                }
            }

            //Map 초기화
            for (int u = 65; u <= 90; u++) {
                alphabets.put((char) u, 0);
            }
        }

        return count;
    }

    @Test
    public void solutionTest() {
        assertThat(solution("CODILITY"), is(96));
    }    
```
* 문자열이 주어지면 1234~, 234~, 34~, 4~ 이런식으로 경우의 수를 돌면서 유니크한 원소의 갯수를 세는 문제다. (중복이 있는 문자는 갯수 세는거에서 제외) 

* 효율성을 보는 문제라서 O(n^2)은 절대 넘어가면 안될 것 같았다. 하지만 O(n^2)은 문제 특성상 어쩔 수 없이 기본적으로 해야하고, 여기서 추가 탐색을 더해야지 앞의 원소들과 비교하면서 이 원소가 유니크한 원소인지 파악할 수 있었다. 그래서 생각에 빠졌다.

* 문제를 다시 읽어본 결과, 입력 문자열이 대문자 영어로만 이루어져있다는 것을 확인하게 되었고, 원소가 얼마 안되고 아스키값으로 연속적이니까 Map으로 Key(알파벳), Value(포함된 갯수)를 미리 셋팅하는 식으로 생각해보았다.

* 결과적으로 해당 알파벳에 갯수만 계속 추가해주면 되고 Key값을 통해 값이 1인 것(유니크)을 찾아서 전체 유니크 갯수 count up을 해주면 되므로 탐색으로 인한 복잡도가 한단계 감소하게 되었다.

* Map을 효율성 문제에서 이렇게 사용하면 좋다는 것을 몸소 체험해보았다.