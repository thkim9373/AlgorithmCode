package baekjoon;

import java.io.*;

// 영화감독 숌
// https://www.acmicpc.net/problem/1436
public class Num1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int goalOfResult = Integer.parseInt(reader.readLine());

        int result = 666;
        int count = 0;
        while (count != goalOfResult) {
            boolean isSatisfy = false;

            int num = result;
            int count6 = 0;
            while (num > 0) {
                if (num % 10 == 6) {
                    if (++count6 == 3) {
                        isSatisfy = true;
                        break;
                    }
                } else {
                    count6 = 0;
                }
                num /= 10;
            }

            if (isSatisfy) {
                count++;
            }

            result++;
        }

        writer.write(--result + "");

        reader.close();
        writer.close();
    }
}

