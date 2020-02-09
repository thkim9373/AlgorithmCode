package programers.hash;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] result = solution(new String[]{"a", "b", "a", "a", "b"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[Math.min(genres.length, 4)];
        Arrays.fill(answer, -1);

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        Map.Entry<String, Integer>[] bestEntryArr = new Map.Entry[2];
        for (Map.Entry<String, Integer> e : hashMap.entrySet()) {
            if (bestEntryArr[0] == null || bestEntryArr[0].getValue() < e.getValue()) {
                if (bestEntryArr[0] != null) bestEntryArr[1] = bestEntryArr[0];
                bestEntryArr[0] = e;
            } else if (bestEntryArr[1] == null || bestEntryArr[1].getValue() < e.getValue()) {
                bestEntryArr[1] = e;
            }
        }

        int[] arr1 = new int[2];
        Arrays.fill(arr1, -1);
        int[] arr2 = new int[2];
        Arrays.fill(arr2, -1);
        for (int i = 0; i < genres.length; i++) {
            if (bestEntryArr[0].getKey().equals(genres[i])) {
                if(arr1[0] < plays[i]) {

                    arr1[0] = plays[i];
                }
            }
        }

        if (bestEntryArr[1] != null) {
            for (int i = 0; i < genres.length; i++) {
                if (bestEntryArr[1].getKey().equals(genres[i])) {
                    if (answer[2] == -1) {
                        answer[2] = i;
                    } else {
                        if (answer[2] < plays[i]) {
                            answer[3] = answer[2];
                            answer[2] = i;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
