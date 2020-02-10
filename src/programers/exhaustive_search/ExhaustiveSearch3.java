package programers.exhaustive_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  모의고사
//  https://programmers.co.kr/learn/courses/30/lessons/42840
public class ExhaustiveSearch3 {
    public static void main(String[] args) {
        int[][] baseball = new int[][] {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        solution(baseball);
    }

    public static int solution(int[][] baseball) {
        Stack<Integer> allNumStack = new Stack<>();
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                if(i == j) continue;
                for(int k = 1; k <= 9; k++) {
                    if(k == i) continue;
                    if(k == j) continue;
                    int num = i * 100 + j * 10 + k;
                    allNumStack.push(num);
                }
            }
        }

        Stack<Integer> answerStack = new Stack<>();
        int allNumber = allNumStack.size();
        for(int i = 0; i < allNumber; i++) {
            int num = allNumStack.pop();

            boolean isEqual = true;
            for(int[] input : baseball) {
                int inputNum = input[0];
                int strike = input[1];
                int ball = input[2];
                if(!isEqualStrikeCount(num, inputNum, strike)) {
                    isEqual = false;
                    break;
                }
                if(!isEqualBallCount(num, inputNum, ball)) {
                    isEqual = false;
                    break;
                }
            }

            if(isEqual) answerStack.push(num);
        }

        return answerStack.size();
    }

    private static boolean isEqualStrikeCount(int num, int answer, int strikeCount) {
        int count = 0;
        int a = num;
        int b = answer;
        while(a > 0) {
            if(a % 10 == b % 10) count++;
            a /= 10;
            b /= 10;
        }
        return count == strikeCount;
    }

    private static boolean isEqualBallCount(int num, int answer, int ballCount) {
        int count = 0;
        int a = num;
        int b = answer;

        int a1, a10, a100;
        int b1, b10, b100;

        a1 = a % 10;
        a /= 10;
        a10 = a % 10;
        a100 = a / 10;

        b1 = b % 10;
        b /= 10;
        b10 = b % 10;
        b100 = b / 10;

        if(a1 == b10 || a1 == b100) count++;
        if(a10 == b1 || a10 == b100) count++;
        if(a100 == b1 || a100 == b10) count++;

        return count == ballCount;
    }
}
