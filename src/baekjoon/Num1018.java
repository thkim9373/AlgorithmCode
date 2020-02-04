package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// 체스판 다시 칠하기
// https://www.acmicpc.net/problem/1018
public class Num1018 {
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(tokenizer.nextToken());
        int column = Integer.parseInt(tokenizer.nextToken());

        board = new char[row][column];

        for (int i = 0; i < row; i++) {
            String inputRow = reader.readLine();
            for (int j = 0; j < column; j++) {
                board[i][j] = inputRow.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= column - 8; j++) {
                result = Math.min(result, getPaintCount(i, j, 'W'));
                result = Math.min(result, getPaintCount(i, j, 'B'));
            }
        }

        writer.write(result + " ");

        reader.close();
        writer.close();
    }

    private static int getPaintCount(int startRow, int startColumn, char startColor) {
        int result = 0;
        char color = startColor;
        for (int a = startRow; a < startRow + 8; a++) {

            for (int b = startColumn; b < startColumn + 8; b++) {
                if (board[a][b] != color) {
                    result++;
                }
                if (color == 'W') {
                    color = 'B';
                } else {
                    color = 'W';
                }
            }

            if (color == 'W') {
                color = 'B';
            } else {
                color = 'W';
            }
        }

        return result;
    }
}