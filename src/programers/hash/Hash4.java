package programers.hash;

import java.util.HashMap;
import java.util.Map;

public class Hash4 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        if(genres.length >= 4) {
            answer = new int[4];
        } else {
            answer = new int[genres.length];
        }


        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        Map.Entry<String, Integer>[] bestEntryArr = new Map.Entry[2];
        for(Map.Entry<String, Integer> e : hashMap.entrySet()) {
            if(bestEntryArr[0] == null || bestEntryArr[0].getValue() < e.getValue()) {
                bestEntryArr[0] = e;
            } else if(bestEntryArr[1] == null || bestEntryArr[1].getValue() < e.getValue()) {
                bestEntryArr[1] = e;
            }
        }

        for(Map.Entry<String, Integer> entry : bestEntryArr) {
            if(entry != null) {
                for(int i = 0; i < genres.length; i++) {
                    if(entry.getKey().equals(genres[i])) {
                        for(int j = 0; j < answer.length; j++) {
                            if(answer[j] < entry.getValue()) {
                                answer[j] = i;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
