package programers.hash;

import java.util.HashMap;
import java.util.Map;

public class Hash4 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        Map.Entry<String, Integer> bestEntry1 = null;
        Map.Entry<String, Integer> bestEntry2 = null;
        for(Map.Entry<String, Integer> e : hashMap.entrySet()) {
            if(bestEntry1 == null || bestEntry1.getValue() < e.getValue()) {
                bestEntry1 = e;
            } else if(bestEntry2 == null || bestEntry2.getValue() < e.getValue()) {
                bestEntry2 = e;
            }
        }

        return answer;
    }
}
