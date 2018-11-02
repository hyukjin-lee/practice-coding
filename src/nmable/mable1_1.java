package nmable;

public class mable1_1 {
    public static String solution(String phrases, int second) {
        StringBuilder result = new StringBuilder("______________");

        second = second % (14 * 2);

        if (second <= 14) {
            int index = 14 - second;
            for (int i = 0; index < 14; index++,i++) {
                result.setCharAt(index, phrases.charAt(i));
            }
        } else {
            int index = second - 14;
            for (int i = 0; index < 14; index++,i++){
                result.setCharAt(i, phrases.charAt(index));
            }
        }

        return result.toString();

    }

    public static void main(String[] args) {
        String result = solution("happy-birthday", 4);
        System.out.println(result);
    }
}
