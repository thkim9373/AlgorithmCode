package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

//  N과 M (4)
//  https://www.acmicpc.net/problem/15652
public class Num15652 {
    private static StringBuilder builder = new StringBuilder();
    private static int n, m;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        result = new int[m];
        getCombination(0, 0);

        writer.write(builder.toString());

        reader.close();
        writer.close();
    }

    private static void getCombination(int v, int count) {
        if (count < m) {
            for (int i = v; i < n; i++) {
                result[count] = i;
                getCombination(i, count + 1);
            }
        } else if (count == m) {
            for (int value : result) {
                builder.append(value + 1).append(" ");
            }
            builder.append("\n");
        }
    }
}
