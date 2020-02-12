package programers.stack_queue;

import java.util.Stack;

//  탑
//  https://programmers.co.kr/learn/courses/30/lessons/42588
public class Example1 {

    public static void main(String[] args) {

        int[] result = solution(new int[]{1, 5, 3, 6, 7, 6, 5});

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

        Stack<Integer> signalStack = new Stack<>();
        Stack<Integer> receiveStack = new Stack<>();
        int index = heights.length;
        while (!heightStack.isEmpty()) {
            signalStack.push(heightStack.pop());
            index--;
            if (heightStack.isEmpty()) break;

            while (!signalStack.isEmpty() && signalStack.peek() < heightStack.peek()) {
                signalStack.pop();
                receiveStack.push(index);
            }
//            if (signalStack.peek() < heightStack.peek()) {
//                while (!signalStack.isEmpty()) {
//                    signalStack.pop();
//                    receiveStack.push(index);
//                }
//            }
        }

        while (!signalStack.isEmpty()) {
            signalStack.pop();
            receiveStack.push(0);
        }

        for(int i = 0; i < answer.length; i++) {
            answer[i] = receiveStack.pop();
        }

        return answer;
    }
}
