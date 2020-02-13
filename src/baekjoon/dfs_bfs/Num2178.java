package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//  미로 탐색
//  https://www.acmicpc.net/problem/2178
public class Num2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String inputRow = reader.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputRow.substring(j, j + 1));
            }
        }

        Graph graph = new Graph(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1) graph.add(i * m + j, i * m + j + 1);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1) graph.add(i * m + j, (i + 1) * m + j);
            }
        }
        int[] check = new int[n * m];
        Arrays.fill(check, -1);
        graph.bfsSearch(check);

        int result = check[n * m - 1];
        writer.write(result + "\n");

        reader.close();
        writer.close();
    }

    static class Graph {
        private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        private boolean[] visited;

        Graph(int v) {
            for (int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }
            visited = new boolean[v];
        }

        void add(int a, int b) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        void bfsSearch(int[] checked) {
            Queue<Integer> queue = new LinkedList<>();
            HashMap<Integer, Boolean> hashMap = new HashMap<>();
            checked[0] = 1;
            queue.offer(0);

            while (!queue.isEmpty()) {
                int temp = queue.poll();
                visited[temp] = true;

                for (int i : graph.get(temp)) {
                    if (!visited[i] && !hashMap.containsKey(i)) {
                        queue.offer(i);
                        hashMap.put(i, false);
                        checked[i] = checked[temp] + 1;
                    }
                }
            }
        }
    }
}
