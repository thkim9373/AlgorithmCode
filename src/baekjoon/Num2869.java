package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// 달팽이는 올라가고 싶다.
// https://www.acmicpc.net/problem/2869
public class Num2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int v = Integer.parseInt(tokenizer.nextToken());

        // a 만큼 올라감(1회)
        v -= a;

        int result;
        if(v <= 0) {    // a 만큼 올라갔을 때 높이가 v 와 같거나 높으면
            result = 1; // 한 번만에 올라감
        } else {    // a 만큼 올라간 후에 높이가 남으면
            result = (v / (a - b)) + 1; // 아침과 밤이 반복됐을 때 올라갈 수 있는 만큼 나눈 몫과 처음 a 만큼 간 1회를 더함
            if(v % (a - b) > 0) result++;   // 나머지가 있다면 한 번 더 올라감
        }

        writer.write(result + "");

        reader.close();
        writer.close();
    }
}
