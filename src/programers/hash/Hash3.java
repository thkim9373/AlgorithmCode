package programers.hash;

import java.util.HashMap;

//  위장
//  https://programmers.co.kr/learn/courses/30/lessons/42578
public class Hash3 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String[] c : clothes) {
            hashMap.put(c[0], hashMap.getOrDefault(c[0], 0) + 1);
        }

        for(String key : hashMap.keySet()) answer *= hashMap.get(key) + 1;

        return answer - 1;
    }
}
