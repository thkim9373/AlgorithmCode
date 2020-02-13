package programers.heap;

import java.util.PriorityQueue;
import java.util.Queue;

//  더 맵게
//  https://programmers.co.kr/learn/courses/30/lessons/42626
public class Example1 {
    public static void main(String[] args) {
        int result = solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(result);
    }

    public static int solution(int[] scoville, int K) {
        int answer = -1;

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.offer(i);
        }

        int count = 0;
        while (queue.size() >= 2 && queue.peek() < K) {
            count++;
            int a = queue.poll();
            int b = queue.poll();

            int c = a + b * 2;
            queue.offer(c);
        }

        if (queue.peek() >= K) answer = count;

        return answer;
    }
}
