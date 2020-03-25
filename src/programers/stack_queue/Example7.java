package programers.stack_queue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

//  주식가격
//  https://programmers.co.kr/learn/courses/30/lessons/42584
public class Example7 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> priceStack = new Stack<>();
        Stack<Integer> positionStack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            for (int position : positionStack) answer[position]++;
            while (!priceStack.isEmpty() && priceStack.peek() > price) {
                priceStack.pop();
                positionStack.pop();
            }

            priceStack.push(price);
            positionStack.push(i);
        }

        return answer;
    }
}
