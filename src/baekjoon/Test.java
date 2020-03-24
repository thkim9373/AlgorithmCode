package baekjoon;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] answer = {};
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        List<String> recordList = new ArrayList<>();
        HashMap<String, String> userHashMap = new HashMap<>();

        for (String s : record) {
            StringTokenizer tokenizer = new StringTokenizer(s);
            String action = tokenizer.nextToken();
            String uid = tokenizer.nextToken();
            String name = "";
            if (tokenizer.hasMoreTokens()) {
                name = tokenizer.nextToken();
            }

            switch (action) {
                case "Enter":
                    userHashMap.put(uid, name);
                    recordList.add(uid + " 님이 들어왔습니다.");
                    break;
                case "Leave":
                    recordList.add(uid + " 님이 나갔습니다.");
                    break;
                case "Change":
                    userHashMap.put(uid, name);
                    break;
            }
        }

        answer = new String[recordList.size()];
        for (int i = 0; i < answer.length; i++) {
            String s = recordList.get(i);
            StringTokenizer tokenizer = new StringTokenizer(s);
            String uid = tokenizer.nextToken();
            String name = userHashMap.get(uid);
            answer[i] = s.replace(uid + " ", name);
        }

        writer.write(Arrays.toString(answer));

        reader.close();
        writer.close();
    }
}
