package baekjoon;

import java.io.*;
import java.util.Stack;

// 제로
// https://www.acmicpc.net/problem/10773
public class Num10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int countOfAction = Integer.parseInt(reader.readLine());

        for(int i = 0; i < countOfAction; i++) {
            int action = Integer.parseInt(reader.readLine());

            if(action == 0) {
                stack.pop();
            } else {
                stack.push(action);
            }
        }

        int result = 0;
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            result += stack.pop();
        }

        writer.write(result + " ");

        reader.close();
        writer.close();
    }
}
