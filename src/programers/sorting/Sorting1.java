package programers.sorting;

import java.util.Arrays;

//  K번째수
//  https://programmers.co.kr/learn/courses/30/lessons/42748
public class Sorting1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int a = 0; a < answer.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            int[] arr = new int[j - i + 1];
            for(int b = 0; b < arr.length; b++) {
                arr[b] = array[i++ - 1];
            }

            Arrays.sort(arr);
            answer[a] = arr[k - 1];
        }

        return answer;
    }
}
