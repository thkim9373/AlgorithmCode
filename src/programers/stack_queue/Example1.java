package programers.stack_queue;

import java.util.Stack;

//  탑
//  https://programmers.co.kr/learn/courses/30/lessons/42588
public class Example1 {

    public static void main(String[] args) {
        // new int[]{1, 5, 3, 6, 7, 6, 5}
        int[] result = solution(new int[]{6, 9, 5, 7, 4});

        for (int s : result) {
            System.out.print(s + " ");
        }

        System.out.println(" ");
    }

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        Stack<Integer> heightStack = new Stack<>();
        for (int height : heights) {
            heightStack.push(height);
        }

        while (!heightStack.isEmpty()) {
            int temp = heightStack.pop();

            for (int i = heightStack.size(); i >= 0; i--) {
                if (temp < heights[i]) {
                    answer[heightStack.size()] = i + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
