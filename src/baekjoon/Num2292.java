package baekjoon;

import java.io.*;

public class Num2292 {
    // 벌집
    // https://www.acmicpc.net/problem/2292
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 1;
        int input = Integer.parseInt(reader.readLine());
        int a = 1;
        while (input > a) {
            a += 6 * result++;
        }

        writer.write(result + "\n");

        writer.close();
        reader.close();
    }
}
