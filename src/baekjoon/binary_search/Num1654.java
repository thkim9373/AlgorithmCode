package baekjoon.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//  랜선 자르기
//  https://www.acmicpc.net/problem/1654
public class Num1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        int[] cableArr = new int[k];

        for (int i = 0; i < cableArr.length; i++) cableArr[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(cableArr);

        long low = 1;
        long max = cableArr[cableArr.length - 1];

        while (low <= max) {
            long mid = (low + max) / 2;

            int count = 0;

            for (int cable : cableArr) {
                count += cable / mid;
            }

            if (count < n) {
                max = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        writer.write(max + "\n");

        reader.close();
        writer.close();
    }
}
