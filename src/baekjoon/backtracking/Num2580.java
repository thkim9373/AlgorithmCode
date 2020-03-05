package baekjoon.backtracking;

import java.io.*;
import java.util.Stack;

//  스도쿠
//  https://www.acmicpc.net/problem/2580
public class Num2580 {
    private static int[][] board = new int[9][9];
    private static Stack<Point> pointStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] strings = reader.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int a = Integer.parseInt(strings[j]);
                board[i][j] = a;
                if (a == 0) {
                    pointStack.add(new Point(j, i));
                }
            }
        }

        getAnswer();

        reader.close();
    }

    private static void getAnswer() {
        if (pointStack.empty()) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            StringBuilder builder = new StringBuilder();
            for (int[] ints : board) {
                for (int i : ints) {
                    builder.append(i).append(" ");
                }
                builder.append("\n");
            }
            try {
                writer.write(builder.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.exit(0);
        }
        Point point = pointStack.pop();
        for (int i = 1; i <= 9; i++) {
            if (isPossible(point, i)) {
                board[point.y][point.x] = i;
                getAnswer();
                board[point.y][point.x] = 0;
            }
        }
        pointStack.push(point);
    }

    private static boolean isPossible(Point point, int num) {
        int x = point.x;
        int y = point.y;

        for (int i = 0; i < 9; i++) {
            if (board[y][i] == num) return false;
            if (board[i][x] == num) return false;
        }

        int xMin, xMax;
        int yMin, yMax;

        xMin = (x / 3) * 3;
        xMax = xMin + 3;

        yMin = (y / 3) * 3;
        yMax = yMin + 3;

        for (int i = yMin; i < yMax; i++) {
            for (int j = xMin; j < xMax; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
