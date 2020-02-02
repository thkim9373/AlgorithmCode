package baekjoon;

import java.io.*;
import java.util.Stack;

// 스택 수열
// https://www.acmicpc.net/problem/1874
public class Num1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalLength = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int targetNum = Integer.parseInt(reader.readLine());
        int countReadNumber = 1;
        boolean isAble = true;
        for (int i = 1; i <= totalLength; ) {

            while (i <= targetNum) {
                stack.push(i++);
                result.append("+\n");
            }

            if (stack.isEmpty()) {
                result = new StringBuilder("NO\n");
                break;
            }

            while (!stack.isEmpty() && targetNum < i) {
                if (stack.peek() == targetNum) {
                    stack.pop();
                    result.append("-\n");
                    if (++countReadNumber <= totalLength) targetNum = Integer.parseInt(reader.readLine());
                } else {
                    result = new StringBuilder("NO\n");
                    isAble = false;
                    break;
                }
            }

            if (!isAble) break;
        }

        if (result.toString().equals("")) result = new StringBuilder("NO\n");

        writer.write(result.toString());

        reader.close();
        writer.close();
    }
}
