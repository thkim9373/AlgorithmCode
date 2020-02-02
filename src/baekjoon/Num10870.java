package baekjoon;

import java.io.*;

// 피보나치 수 5
// https://www.acmicpc.net/problem/10870
public class Num10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(reader.readLine());

        writer.write(fibonacci(input) + "");

        reader.close();
        writer.close();
    }

    private static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
