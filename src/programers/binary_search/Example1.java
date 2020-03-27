package programers.binary_search;

import java.util.Arrays;

//  예산
//  https://programmers.co.kr/learn/courses/30/lessons/43237
public class Example1 {
    public static void main(String[] args) {
//        new int[]{120, 110, 140, 150}, 485)
//        new int[]{100, 100, 100, 100}, 400)
        System.out.println(solution(new int[]{120, 110, 140, 150}, 485));
    }

    public static int solution(int[] budgets, int M) {
        int answer = 0;

        Arrays.sort(budgets);
        int max = budgets[budgets.length - 1];
        int min = 0;
        int temp;
        while (max >= min) {
            temp = (max + min) / 2;
            int possibleBudget = getPossibleBudget(budgets, temp);
            if (possibleBudget >= M) {
                max = temp - 1;
            } else {
                min = temp + 1;
            }
            if (possibleBudget <= M) {
                answer = temp;
            }
        }

        return answer;
    }

    private static int getPossibleBudget(int[] budgets, int boundary) {
        int result = 0;
        for (int budget : budgets) {
            result += Math.min(boundary, budget);
        }
        return result;
    }
}
