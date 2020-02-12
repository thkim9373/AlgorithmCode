package programers.dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Num3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = solution("aab", "bbb", new String[]{"abb", "bbb"});

        writer.write(result + "\n");

        reader.close();
        writer.close();
    }

    public static int solution(String begin, String target, String[] words) {
        int targetIndex = 0;
        boolean containTarget = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                containTarget = true;
                targetIndex = i + 1;
                break;
            }
        }
        if (!containTarget) return 0;

        int n = words.length + 1;

        String[] allWords = new String[n];
        allWords[0] = begin;

        System.arraycopy(words, 0, allWords, 1, allWords.length - 1);

        Graph graph = new Graph(n);

        for (int i = 0; i < allWords.length - 1; i++) {
            String a = allWords[i];
            for (int j = i + 1; j < allWords.length; j++) {
                String b = allWords[j];

                int equalCharCount = 0;
                boolean[] isContain = new boolean[b.length()];
                for (int k = 0; k < a.length(); k++) {
                    String s = a.substring(k, k + 1);
                    for (int z = 0; z < b.length(); z++) {
                        if (!isContain[z]) {
                            String d = b.substring(z, z + 1);
                            if (s.equals(d)) {
                                isContain[z] = true;
                                equalCharCount++;
                                break;
                            }

                        }
                    }
                }
                if (equalCharCount == a.length() - 1) graph.add(i, j);
            }
        }

        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        graph.bfs(visited);

        return visited[targetIndex] != -1 ? visited[targetIndex] : 0;
    }

    public static class Graph {
        private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        Graph(int n) {
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
        }

        void add(int a, int b) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        void bfs(int[] visited) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            visited[0] = 0;

            while (!queue.isEmpty()) {
                int temp = queue.poll();

                for (int i : graph.get(temp)) {
                    if (visited[i] == -1) {
                        visited[i] = visited[temp] + 1;
                        queue.offer(i);
                    }
                }
            }
        }
    }
}
