package baekjoon;

import java.io.*;
import java.util.Stack;

// 괄호
// https://www.acmicpc.net/problem/9012
public class Num9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int countOfAction = Integer.parseInt(reader.readLine());

        for (int i = 0; i < countOfAction; i++) {
            Stack<Character> stack = new Stack<>();

            String input = reader.readLine();
            for (int j = 0; j < input.length(); j++) {
                stack.push(input.charAt(j));
            }

            boolean isVPS = false;
            int countOfOpen = 0;
            int countOfClose = 0;
            for (int k = stack.size(); k > 0; k--) {
                if (stack.pop() == '(') {
                    if (++countOfOpen > countOfClose) {
                        break;
                    }
                } else {
                    countOfClose++;
                }
            }

            if (countOfOpen == countOfClose) isVPS = true;

            writer.write(isVPS ? "YES \n" : "NO \n");
        }

        reader.close();
        writer.close();
    }
}
