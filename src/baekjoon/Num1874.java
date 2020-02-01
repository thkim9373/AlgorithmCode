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
        String result = "";

        for(int i = 1; i <= totalLength; i++) {
            int targetNum = Integer.parseInt(reader.readLine());
            for(int j = i; j <= targetNum; j++) {
                stack.push(j);
                result += "+\n";
            }

            if(!stack.isEmpty() && stack.peek() == targetNum) {
                stack.pop();
                result += "-\n";
            } else {
                result = "NO\n";
                break;
            }
        }

        writer.write(result);

//        int targetNum = Integer.parseInt(reader.readLine());
//        for (int i = 1; i <= totalLength; i++) {
//            if (targetNum >= i) {
//                stack.push(i);
//                result += "+\n";
//                continue;
//            }
//            while (true) {
//                if (!stack.isEmpty() && stack.peek() == targetNum) {
//                    stack.pop();
//                    result += "-\n";
//                    targetNum = Integer.parseInt(reader.readLine());
//                    continue;
//                }
//                if (i <= targetNum) {
//                    stack.push(i);
//                    result += "+\n";
//                    break;
//                } else {
//                    result = "NO\n";
//                    break;
//                }
//            }
//        }
//
//        int stackSize = stack.size();
//        for(int i = 0; i < stackSize; i++) {
//            if (!stack.isEmpty() && stack.peek() == targetNum) {
//                stack.pop();
//                result += "-\n";
//                if(!stack.isEmpty()) targetNum = Integer.parseInt(reader.readLine());
//            } else {
//                result = "NO\n";
//                break;
//            }
//        }
//
//        writer.write(result);

        reader.close();
        writer.close();
    }
}
