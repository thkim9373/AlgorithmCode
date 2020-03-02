package baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;

//  스도쿠
//  https://www.acmicpc.net/problem/2580
public class Num2580 {
    private static int[][] board = new int[9][9];
    private static int[][] answer = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 9; i++) {
            String[] strings = reader.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(strings[j]);
            }
        }

        getAnswer(0, 0);

        StringBuilder builder = new StringBuilder();
        for (int[] ints : board) {
            for (int i : ints) {
                builder.append(i).append(" ");
            }
            builder.append("\n");
        }

        writer.write(builder.toString());

        reader.close();
        writer.close();
    }

    private static void getAnswer(int x1, int y1) {
        if (isComplete()) {
            for (int y = 0; y < 9; y++) {
                System.arraycopy(board[y], 0, answer[y], 0, 9);
            }
        }
        for (int y = y1; y < 9; y++) {
            for (int x = x1; x < 9; x++) {
                if (board[y][x] == 0) {
                    boolean[] possibleNum = getPossibleNum(x, y);
                    for (int i = 0; i < possibleNum.length; i++) {
                        if (possibleNum[i]) {
                            board[y][x] = i + 1;
                            getAnswer(x, y);
                        }
                    }
                }
            }
        }
    }

    private static boolean[] getPossibleNum(int x, int y) {
        boolean[] result = new boolean[9];
        Arrays.fill(result, true);

        for (int i = 0; i < 9; i++) {
            if (board[y][i] != 0) result[board[y][i] - 1] = false;
            if (board[i][x] != 0) result[board[i][x] - 1] = false;
        }

        int xMin, xMax;
        int yMin, yMax;

        xMin = (x / 3) * 3;
        xMax = xMin + 3;

        yMin = (y / 3) * 3;
        yMax = yMin + 3;

        for (int i = yMin; i < yMax; i++) {
            for (int j = xMin; j < xMax; j++) {
                if (board[i][j] != 0) result[board[i][j] - 1] = false;
            }
        }

        return result;
    }

    private static boolean isComplete() {
        for (int[] ints : board) {
            for (int i : ints) {
                if (i == 0) return false;
            }
        }
        return true;
    }
}
