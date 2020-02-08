package programers.hash;

import java.util.HashMap;
import java.util.Map;

//  전화번호 목록
//  https://programmers.co.kr/learn/courses/30/lessons/42577
public class Hash2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String num : phone_book) {
            for(Map.Entry<String, Integer> e : hashMap.entrySet()) {
                if(e.getValue() >= num.length()) {
                    if(e.getKey().substring(0, num.length()).equals(num)) return false;
                } else {
                    if(num.substring(0, e.getKey().length()).equals(e.getKey())) return false;
                }
            }

            hashMap.put(num, num.length());
        }

        return answer;
    }
}
