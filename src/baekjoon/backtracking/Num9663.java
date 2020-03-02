package baekjoon.backtracking;

import java.io.*;

//  N-Queen
//  https://www.acmicpc.net/problem/9663
public class Num9663 {
    private static int n;
    private static int[] rows;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        rows = new int[n];

        getNQueen(0);

        writer.write(result + "\n");

        reader.close();
        writer.close();
    }

    private static void getNQueen(int count) {
        if (count < n) {
            for (int i = 0; i < n; i++) {
                rows[count] = i;
                if (isPossible(count)) {
                    getNQueen(count + 1);
                }
            }
        } else if (count == n) {
            result++;
        }
    }

    private static boolean isPossible(int count) {
        for (int i = 0; i < count; i++) {
            if (rows[i] == rows[count] || count - i == Math.abs(rows[i] - rows[count])) {
                return false;
            }
        }
        return true;
    }
}
