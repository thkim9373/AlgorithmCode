package baekjoon;

import java.io.*;

public class Num2839 {
    // 설탕 배달
    // https://www.acmicpc.net/problem/2839
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(reader.readLine());
        int result = 0;
        int a, b;

        boolean isComplete = false;
        for (int i = input / 5; i >= 0; i--) {
            a = 5 * i;
            for (int j = (input - a) / 3; j >= 0; j--) {
                b = 3 * j;
                if (a + b == 0) break;
                if (input % (a + b) == 0) {
                    result += i + j;
                    isComplete = true;
                    break;
                }
            }
            if (isComplete) break;
        }
        if (!isComplete) result = -1;

        writer.write(result + "");

        writer.close();
        reader.close();
    }
}
