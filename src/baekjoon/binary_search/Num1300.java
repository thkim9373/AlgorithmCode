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

        int min = 1;
        int max = k;
        int result = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt >= k) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }

        writer.write(result + " ");
        reader.close();
        writer.close();
    }
}
