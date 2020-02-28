package baekjoon.binary_search;

import java.io.*;

//  K번째 수
//  https://www.acmicpc.net/problem/1300
public class Num1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        int result;

        if (n == 0 || k % n == 0) {
            writer.write(0 + " ");
            writer.close();
            reader.close();
            return;
        }

        result = (k / n) * (k % n);

        writer.write(result + " ");
        reader.close();
        writer.close();
    }
}
