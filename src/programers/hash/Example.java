package programers.hash;

import java.io.IOException;
import java.util.*;
import java.util.Arrays;


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
        Set<Integer> set = new HashSet<>();

        //  문자열
        String s = "";
        s.length();
        s.equals("");
        s.contains("|");
        s.substring(1, 2);
        String[] strings = new String[2];
        int[] ints = new int[65];

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
    }
}
