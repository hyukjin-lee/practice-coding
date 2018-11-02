package skp11;

public class number1_final {

    private static int count = 0;

    public static int solution(int[] numbers) {
        findNextNode(numbers, 0);
        return count;
    }

    private static void findNextNode(int[] numbers, int index) {
        if(index > numbers.length){
            return;
        }

        if (numbers[index] == -1) {
            count++;
            return;
        }
        count++;
        findNextNode(numbers, numbers[index]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,4,0,3,2}));
    }
}
