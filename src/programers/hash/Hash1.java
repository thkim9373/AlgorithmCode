package programers.hash;

import java.util.HashMap;
import java.util.Map;

//  완주하지 못한 선수
//  https://programmers.co.kr/learn/courses/30/lessons/42576
public class Hash1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(String name : participant) {
            if(hashMap.containsKey(name)) {
                hashMap.replace(name, hashMap.get(name) + 1);
            } else {
                hashMap.put(name, 1);
            }
        }

        for(String name : completion) {
            hashMap.replace(name, hashMap.get(name) - 1);
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() == 1) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}
