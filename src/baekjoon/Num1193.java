package baekjoon;

import java.io.*;

public class Num1193 {
    // 분수찾기
    // https://www.acmicpc.net/problem/1193
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(reader.readLine());

        int count = 1;
        while (input > count) {
            input -= count++;
        }
        count += 1;
        int a, b;
        if (count % 2 != 0) {
            a = input;
            b = count - input;
        } else {
            b = input;
            a = count - input;
        }

        writer.write(a + "/" + b);

        writer.close();
        reader.close();
    }
}
