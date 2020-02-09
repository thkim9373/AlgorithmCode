package programers.exhaustive_search;

import java.util.ArrayList;
import java.util.List;

//  모의고사
//  https://programmers.co.kr/learn/courses/30/lessons/42840
public class ExhaustiveSearch {
    public int[] solution(int[] answers) {
        int[] answer;

        int[] patternA = new int[] {1, 2, 3, 4, 5};
        int countA = 0;
        int[] patternB = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int countB = 0;
        int[] patternC = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int countC = 0;

        for(int i = 0; i < answers.length; i++) {
            int a = patternA[i % patternA.length];
            int b = patternB[i % patternB.length];
            int c = patternC[i % patternC.length];

            if(answers[i] == a) countA++;
            if(answers[i] == b) countB++;
            if(answers[i] == c) countC++;
        }

        int max = Math.max(countA, countB);
        max = Math.max(max, countC);

        List<Integer> resultList = new ArrayList<>();
        if(max == countA) resultList.add(1);
        if(max == countB) resultList.add(2);
        if(max == countC) resultList.add(3);

        answer = new int[resultList.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}
