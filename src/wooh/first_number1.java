package wooh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class first_number1 {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (token.equals("DUP")) {
                stack.push(stack.peek());

            } else if (token.equals("POP")) {
                stack.pop();

            } else if (token.equals("+")) {
                int firstNum, secondNum;

                firstNum = stack.peek();
                stack.pop();

                secondNum = stack.peek();
                stack.pop();
                stack.push(firstNum + secondNum);

            } else if (token.equals("-")) {
                int firstNum, secondNum;

                firstNum = stack.peek();
                stack.pop();

                secondNum = stack.peek();
                stack.pop();

                stack.push(Math.abs(firstNum-secondNum));

            } else {
                stack.push(Integer.parseInt(token));
            }

        }

        System.out.println(stack.pop());
    }
}
