package programers.exhaustive_search;

import java.util.ArrayList;
import java.util.List;

//  소수 찾기
//  https://programmers.co.kr/learn/courses/30/lessons/42839
public class ExhaustiveSearch2 {
    public static void main(String[] args) {
        solution("17");
    }

    public static int solution(String numbers) {
        int answer = 0;

        int[] countArr = new int[10];
        for(int i = 0; i < numbers.length(); i++) {
            countArr[Integer.parseInt(numbers.substring(i, i + 1))]++;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < countArr[i]; j++) {
                builder.append(i);
            }
        }
        int max = Integer.parseInt(builder.toString());

        int[] pArr = new int[max + 1];
        List<Integer> compareList = new ArrayList<>();
        for(int i = 2; i < pArr.length; i++) {

            if(pArr[i] != 0) continue;
            for(int j = i * 2; j < pArr.length; j += i) {
                pArr[j]--;
            }

            boolean isPNum = true;

            int a = i;
            while(a > 0) {
                if(countArr[a % 10] == 0) {
                    isPNum = false;
                    break;
                }
                a /= 10;
            }
            if(isPNum) compareList.add(i);
        }


        for (Integer integer : compareList) {
            int[] arr = new int[10];
            int num = integer;

            boolean isPrimeNumber = true;

            while (num > 0) {
                if (countArr[num % 10] < ++arr[num % 10]) {
                    isPrimeNumber = false;
                    break;
                }
                num /= 10;
            }

            if (isPrimeNumber) answer++;
        }

        return answer;
    }
}
