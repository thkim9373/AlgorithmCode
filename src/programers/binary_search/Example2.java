package programers.binary_search;

import java.util.Arrays;

public class Example2 {
    public static void main(String[] args) {
//        6, new int[] {7, 10}
//        6, new int[] {5, 5}
        System.out.println(solution(6, new int[]{5, 7}));
    }

    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);
        long min = 0;
        long max = n * times[times.length - 1];
        long mid;

        while (min <= max) {
            mid = (max + min) / 2;
            long numOfPersons = 0;
            for (int time : times) {
                numOfPersons += mid / time;
            }

            if (numOfPersons >= n) {
                answer = Math.min(answer, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
}
