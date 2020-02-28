package baekjoon.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//  공유기 설치
//  https://www.acmicpc.net/problem/2110
public class Num2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        int[] distanceArr = new int[n];
        for (int i = 0; i < distanceArr.length; i++) distanceArr[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(distanceArr);

        int min = 1;
        int max = distanceArr[distanceArr.length - 1];

        while (min <= max) {
            int gap = (min + max) / 2;
            int count = 1;
            int prevHouse = distanceArr[0];
            for (int i = 1; i < distanceArr.length; i++) {
                if (distanceArr[i] - prevHouse >= gap) {
                    if (++count == c) break;
                    prevHouse = distanceArr[i];
                }
            }

            if (count == c) {
                min = gap + 1;
            } else {
                max = gap - 1;
            }
        }

        writer.write(max + "\n");

        reader.close();
        writer.close();
    }
}
