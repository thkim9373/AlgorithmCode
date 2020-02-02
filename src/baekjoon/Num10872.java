package baekjoon;

import java.io.*;

// 팩토리얼
// https://www.acmicpc.net/problem/10872
public class Num10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(reader.readLine());

        writer.write(factorial(input) + "");

        reader.close();
        writer.close();
    }

    private static int factorial(int n) {
        if(n > 1) {
            return n * factorial(n-1);
        } else {
            return 1;
        }
    }
}
