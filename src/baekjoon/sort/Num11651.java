package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//  좌표 정렬하기 2
//  https://www.acmicpc.net/problem/11651
public class Num11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            points[i] = new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }
        Arrays.sort(points);

        StringBuilder builder = new StringBuilder();
        for (Point point : points) {
            builder.append(point.x).append(" ").append(point.y).append("\n");
        }

        writer.write(builder.toString());

        reader.close();
        writer.close();
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.y != o.y) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
}
