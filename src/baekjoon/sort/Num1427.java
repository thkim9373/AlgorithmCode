package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

//  소트인사이드
//  https://www.acmicpc.net/problem/1427
public class Num1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = reader.readLine();
        String[] arr = num.split("");
        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder builder = new StringBuilder();
        for (String s : arr) builder.append(s);

        writer.write(builder.toString());

        reader.close();
        writer.close();
    }
}
