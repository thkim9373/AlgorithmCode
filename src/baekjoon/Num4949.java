package baekjoon;

import java.io.*;
import java.util.Stack;

// 균형잡힌 세상
// https://www.acmicpc.net/problem/4949
public class Num4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();

            if(input.equals(".")) {
                bw.flush();
                bw.close();
                return;
            }

            Stack<Character> stack = new Stack<>();
            boolean result = true;

            // 한 글자씩 검사
            for(char one : input.toCharArray()) {
                if(one == '(' || one == '[')
                    stack.push(one);
                else if(one == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {
                        result = false;
                        break;
                    }
                } else if(one == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') {
                        result = false;
                        break;
                    }
                }
            }

            // 모든 검사가 끝났는데 스택이 비어있지 않다면 균형잡히지 않은 것
            if(!stack.isEmpty())
                result = false;

            if(!result)
                bw.write("no\n");
            else
                bw.write("yes\n");
        }
    }
}
