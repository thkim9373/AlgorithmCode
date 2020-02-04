package baekjoon;

import java.io.*;

// 분해합
// https://www.acmicpc.net/problem/2231
public class Num2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputSting = reader.readLine();
        int input = Integer.parseInt(inputSting);
        int result = 0;

        for (int i = inputSting.length() * 9; i < input; i++) {
            int num = i;

            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (i + sum == input) {
                result = i;
                break;
            }
        }

        writer.write(result + " ");

        reader.close();
        writer.close();
    }
}
