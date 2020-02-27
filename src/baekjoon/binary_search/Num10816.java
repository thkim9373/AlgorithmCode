package baekjoon.binary_search;

import java.io.*;
import java.util.*;

//  숫자 카드 2
//  https://www.acmicpc.net/problem/10816
public class Num10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        while (tokenizer.hasMoreTokens()) {
            String key = tokenizer.nextToken();
            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        String m = reader.readLine();

        tokenizer = new StringTokenizer(reader.readLine());

        StringBuilder builder = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            String key = tokenizer.nextToken();
            if (!map.containsKey(key)) {
                builder.append(0).append(" ");
            } else {
                builder.append(map.get(key)).append(" ");
            }
        }
        writer.write(builder.toString());

        reader.close();
        writer.close();
    }
}
