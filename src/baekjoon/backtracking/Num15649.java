package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

//  N과 M (1)
//  https://www.acmicpc.net/problem/15649
public class Num15649 {
    private static StringBuilder builder = new StringBuilder();
    private static int n, m;
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        visited = new boolean[n];
        result = new int[m];
        getCombination(0);

        writer.write(builder.toString());

        reader.close();
        writer.close();
    }

    private static void getCombination(int apply) {
        if (apply < m) {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[apply] = i;
                    getCombination(apply + 1);
                    visited[i] = false;
                }
            }
        } else if (apply == m) {
            for (int value : result) {
                builder.append(value + 1).append(" ");
            }
            builder.append("\n");
        }
    }
}
