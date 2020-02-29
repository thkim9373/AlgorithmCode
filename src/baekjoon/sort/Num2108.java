package baekjoon.sort;

import java.io.*;
import java.util.Arrays;

//  통계학
//  https://www.acmicpc.net/problem/2108
public class Num2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);

        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        long arithmeticMean = Math.round(sum / n);
        int median = arr[arr.length / 2];

        int mode = 0;
        int[] countArr = new int[8001];
        for (int i : arr) {
            countArr[i + 4000]++;
        }
        int max = 0;
        for (int i : countArr) {
            if (max == i) {

            } else {
                max = Math.max(max, i);
            }
        }

        reader.close();
        writer.close();
    }
}
