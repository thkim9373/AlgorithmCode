package programers.stack_queue;

import java.util.Stack;

//  쇠막대기
//  https://programmers.co.kr/learn/courses/30/lessons/42585
public class Example5 {

    public static void main(String[] args) {
//        "()(((()())(())()))(())"
//        "(())"
        int result = solution("()(((()())(())()))(())");

        System.out.println(result);

        System.out.println(" ");
    }

    public static int solution(String arrangement) {
        int answer = 0;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < arrangement.length(); i++) {
            if (i + 2 <= arrangement.length() && arrangement.substring(i, i + 2).equals("()")) {
                answer += stack.size();
                i++;
                continue;
            }

            String input = arrangement.substring(i, i + 1);

            if (!stack.isEmpty() && (stack.peek().equals("(") && input.equals(")"))) {
                stack.pop();
                answer++;
            } else {
                stack.push(input);
            }
        }

        return answer;
    }
}
