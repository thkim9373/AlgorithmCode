package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 10250 ACM 호텔
        // https://www.acmicpc.net/problem/10250
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(reader.readLine());

        for(int i = 0; i < total; i++) {
            writer.write(getRoomNum(reader.readLine()) + "");
        }

        reader.close();
        writer.close();
    }

    private static String getRoomNum(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        int h = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        int yy = n % h != 0 ? n % h : 1;
        int xx = n % h != 0 ? (n / h) + 1 : 1;
        StringBuilder builder = new StringBuilder();
        builder.append(yy);
        if(xx >= 10) {
            builder.append(xx);
        } else {
            builder.append("0").append(xx);
        }
        builder.append("\n");
        return builder.toString();
    }
}
