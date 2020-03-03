package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//  좌표 정렬하기 2
//  https://www.acmicpc.net/problem/11651
public class Num10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        People[] peoples = new People[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            peoples[i] = new People(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken());
        }
        Arrays.sort(peoples);

        StringBuilder builder = new StringBuilder();
        for (People people : peoples) {
            builder.append(people.age).append(" ").append(people.name).append("\n");
        }

        writer.write(builder.toString());

        reader.close();
        writer.close();
    }

    private static class People implements Comparable<People> {
        int age;
        String name;

        People(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(People o) {
            return this.age - o.age;
        }
    }
}
