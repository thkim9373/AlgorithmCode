package programers.cacao.Years2020;

import java.util.Stack;

//  [2020카카오공채] 괄호 변환
//  https://programmers.co.kr/learn/courses/30/lessons/60058
public class Example2 {

    public static void main(String[] args) {
        String result = solution("()))((()");

        System.out.println(result);
    }

    public static String solution(String s) {
        if (s.equals("")) return "";

        int openCount = 0;
        int closeCount = 0;

        int divideIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }

            if (openCount == closeCount) {
                divideIndex = i + 1;
                break;
            }
        }

        String u = s.substring(0, divideIndex);
        String v = s.substring(divideIndex);

        if (isComplete(u)) {
            v = solution(v);
            return u + v;
        } else {
            String o = "(";
            o += solution(v) + ")";
            u = reverseString(u);
            return o + u;
        }
    }

    private static boolean isComplete(String s) {
        Stack<Character> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stringStack.push(c);
            } else {
                if (!stringStack.isEmpty() && stringStack.peek() == '(') {
                    stringStack.pop();
                } else {
                    return false;
                }
            }
        }

        return stringStack.isEmpty();
    }

    private static String reverseString(String s) {
        StringBuilder o = new StringBuilder();
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(') {
                o.append(")");
            } else {
                o.append("(");
            }
        }
        return o.toString();
    }
}
