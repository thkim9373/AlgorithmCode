package baekjoon;

import java.io.*;

//  수 정렬하기 3(카운팅 정렬)
//  https://www.acmicpc.net/problem/10989
public class Num10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int countTotal = Integer.parseInt(reader.readLine());
        int[] arr = new int[countTotal];
        for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(reader.readLine());

        int[] countArr = new int[10001];
        for (int i : arr) {
            countArr[i]++;
        }

        for(int i = 0; i < countArr.length - 1; i++) {
            countArr[i + 1] += countArr[i];
        }

        int[] result = new int[arr.length];

        for (int i : arr) {
            if(countArr[i] != 0) result[countArr[i]-- - 1] = i;
        }

        for (int i : result) writer.write(i + "\n");

        reader.close();
        writer.close();
    }
}
