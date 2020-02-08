package programers.hash;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Example {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10];
        Arrays.sort(arr);

        // 해시맵
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.size();
        hashMap.keySet().size();
        Collection<Integer> collection = hashMap.values();
        hashMap.getOrDefault("", 1);
        hashMap.get("");
        Map.Entry<String, Integer> entry = null;
        hashMap.entrySet();
        entry.getKey().substring(1, 2).equals("");

        //  문자열
        String s = "";
        s.length();
        s.equals("");
        s.contains("|");
        s.substring(1, 2);
    }
}
