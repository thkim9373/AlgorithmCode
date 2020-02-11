package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//  바이러스
//  https://www.acmicpc.net/problem/2606
public class Num2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        Graph graph = new Graph(v);

        for (int i = 0; i < e; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            graph.add(a, b);
        }

        graph.bfs(1);

        writer.write(graph.getCount() + "\n");

        reader.close();
        writer.close();
    }

    public static class Graph {

        private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        private boolean[] visited;
        private int count = 0;

        Graph(int v) {
            for (int i = 0; i < v + 1; i++) {
                graph.add(new ArrayList<>());
            }
            visited = new boolean[v + 1];
        }

        void add(int a, int b) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        void dfs(int a) {
            if (!visited[a]) {
                visited[a] = true;
                count++;

                for (int b : graph.get(a)) {
                    dfs(b);
                }
            }
        }

        void bfs(int a) {
            Queue<Integer> queue = new LinkedList<>();
            HashMap<Integer, Boolean> hashMap = new HashMap<>();
            queue.offer(a);

            while (!queue.isEmpty()) {
                int temp = queue.poll();
                visited[temp] = true;
                count++;

                for(int i : graph.get(temp)) {
                    if(!visited[i] && !hashMap.containsKey(i)) {
                        queue.offer(i);
                        hashMap.put(i, true);
                    }
                }
            }
        }

        int getCount() {
            return count - 1;
        }
    }
}
