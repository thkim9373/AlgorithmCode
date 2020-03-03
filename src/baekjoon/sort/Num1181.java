package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

//  단어 정렬
//  https://www.acmicpc.net/problem/1181
public class Num1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(reader.readLine());
        }

//        List<String> stringList = new ArrayList<>(set);
//        stringList.sort((o1, o2) -> {
//            if (o1.length() != o2.length()) {
//                return o1.length() - o2.length();
//            } else {
//                return o1.compareTo(o2);
//            }
//        });

        String[] arr = new String[set.size()];
        set.toArray(arr);
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });


        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s).append("\n");
        }
        writer.write(builder.toString());

        reader.close();
        writer.close();
    }
}
