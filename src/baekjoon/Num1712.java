package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Num1712 {
    // 손익분기점
    // https://www.acmicpc.net/problem/1712
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int result;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        if (b >= c) {
            result = -1;
        } else {
            result = (a / (c - b)) + 1;
        }

        writer.write(result + "");

        writer.close();
        reader.close();
    }
}
