package baekjoon.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//  나무 자르기
//  https://www.acmicpc.net/problem/2805
public class Num2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] treeArr = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < treeArr.length; i++) {
            treeArr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(treeArr);

        long min = 0;
        long max = treeArr[treeArr.length - 1];

        while (min <= max) {
            long mid = (min + max) / 2;
            long totalTree = 0;

            for(int i = treeArr.length - 1; i >= 0; i--) {
                if(treeArr[i] > mid) {
                    totalTree += treeArr[i] - mid;
                } else {
                    break;
                }
            }

            if(totalTree >= m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        writer.write(max + " ");

        reader.close();
        writer.close();
    }
}
