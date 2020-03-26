package programers.binary_search;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;

public class Example1 {
    public static void main(String[] args) {
//        new int[]{120, 110, 140, 150}, 485)
        System.out.println(solution(new int[]{100, 100, 100, 100}, 400));
    }

    public static int solution(int[] budgets, int M) {
        int answer = 0;

        Arrays.sort(budgets);
        int maxResult = budgets[budgets.length - 1];
        int minResult = 0;
        int temp = maxResult / 2;

        while (maxResult > minResult) {
            int possibleBudget = getPossibleBudget(budgets, temp);
            if (possibleBudget >= M) {
                maxResult = temp;
                temp = (minResult + temp -1) / 2;
            } else {
                minResult = temp;
                temp = (maxResult + temp) / 2;
            }
        }

        answer = temp;
        return answer;
    }

    public static int getPossibleBudget(int[] budgets, int boundary) {
        int result = 0;
        for (int budget : budgets) {
            result += Math.min(boundary, budget);
        }
        return result;
    }
}
