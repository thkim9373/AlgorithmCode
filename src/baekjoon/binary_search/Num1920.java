package baekjoon.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//  수 찾기
//  https://www.acmicpc.net/problem/1920
public class Num1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] a = new int[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            a[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(a);

        int m = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens()) {
            if(Arrays.binarySearch(a, Integer.parseInt(tokenizer.nextToken())) >= 0) {
                writer.write(1 + "\n");
            } else {
                writer.write(0 + "\n");
            }
        }

        reader.close();
        writer.close();
    }
}
