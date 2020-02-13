package programers.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//  주식가격
//  https://programmers.co.kr/learn/courses/30/lessons/42584
public class Example6 {

    public static void main(String[] args) {
        int result[] = solution(new int[]{1, 2, 3, 2, 3,});

        System.out.println(Arrays.toString(result));

        System.out.println(" ");
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList<>();
        for (int i : prices) {
            queue.offer(i);
        }

        int start = 0;
        int end = 0;
        while (!queue.isEmpty()) {
            end++;
            for (int i = start; i < end; i++) {
                answer[i]++;
            }
            int temp = queue.poll();

            if (!queue.isEmpty() && temp > queue.peek()) {
                start = end;
            }
        }

        return answer;
    }
}
