package programers.exhaustive_search;

import java.util.ArrayList;
import java.util.List;

//  모의고사
//  https://programmers.co.kr/learn/courses/30/lessons/42840
public class ExhaustiveSearch2 {
    public static void main(String[] args) {
        solution("17");
    }

    public static int solution(String numbers) {
        int answer = 0;

        List<Integer> primeNumberList = new ArrayList<>();
        primeNumberList.add(2);
        for(int i = 3; i < Math.pow(10, numbers.length()); i++) {
            boolean isPNum = true;
            for(int j = 0; j < primeNumberList.size(); j++) {
                if (i % primeNumberList.get(j) == 0) {
                    isPNum = false;
                    break;
                }
            }
        }

        int[] countArr = new int[10];
        for(int i = 0; i < numbers.length(); i++) {
            countArr[Integer.parseInt(numbers.substring(i, i + 1))]++;
        }

        for(int i = 0; i < primeNumberList.size(); i++) {
            int[] arr = new int[10];
            int num = primeNumberList.get(i);
            while(num > 0) {
                arr[num % 10]++;
                num /= 10;
            }

            boolean isPrimeNumber = true;

            for(int j = 0; j < arr.length; j++) {
                if(countArr[j] < arr[j]) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if(isPrimeNumber) answer++;
        }

        return answer;
    }
}
