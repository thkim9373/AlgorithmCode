package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Num2798 {
    public static void main(String[] args) throws IOException {
        // 블랙잭
        // https://www.acmicpc.net/problem/2798
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numOfCards = Integer.parseInt(tokenizer.nextToken());
        int goalNumber = Integer.parseInt(tokenizer.nextToken());

        String[] cards = reader.readLine().split(" ");
        int result = 0;

        for (int i = 0; i < numOfCards - 2; i++) {
            int a = Integer.parseInt(cards[i]);

            if (a >= goalNumber) continue;

            for (int j = i + 1; j < numOfCards - 1; j++) {
                int b = Integer.parseInt(cards[j]);

                if (a + b >= goalNumber) continue;

                for (int k = j + 1; k < numOfCards; k++) {
                    int c = Integer.parseInt(cards[k]);
                    int sum = a + b + c;

                    if (sum <= goalNumber) {
                        result = Math.max(result, a + b + c);
                    }
                }
            }
        }

        writer.write(result + " ");

        reader.close();
        writer.close();
    }
}
