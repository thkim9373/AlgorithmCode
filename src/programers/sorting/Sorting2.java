package programers.sorting;

import java.util.*;

//  가장 큰 수
//  https://programmers.co.kr/learn/courses/30/lessons/42746
class Sorting2 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] stringNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(stringNumbers[0].charAt(0) == '0') return "0";

        for(String s : stringNumbers) {
            answer.append(s);
        }

        return answer.toString();
    }
}