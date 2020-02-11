package baekjoon.dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//  유기농 배추
//  https://www.acmicpc.net/problem/1012
public class Num1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalAction = Integer.parseInt(reader.readLine());
        int[] answer = new int[totalAction];

        for(int z = 0; z < totalAction; z++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int m = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            int[][] map = new int[n][m];
            for(int j = 0; j < k; j++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());

                map[b][a] = 1;
            }

            Graph graph = new Graph(n * m);
            graph.setMap(map);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if (map[i][j] == 1 && map[i][j + 1] == 1) {
                        graph.add(i * m + j, i * m + j + 1);
                    }
                }
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && map[i + 1][j] == 1) {
                        graph.add(i * m + j, (i + 1) * m + j);
                    }
                }
            }

            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < graph.getNodeCount(); i++) {
                graph.dfs(i);

                if (graph.getCount() != 0) {
                    resultList.add(graph.getCount());
                }

                graph.countClear();
            }

            answer[z] = resultList.size();
        }

        for (int i : answer) {
            writer.write(i + "\n");
        }

        reader.close();
        writer.close();
    }

    public static class Graph {

        private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        private int[][] map;
        private boolean[] visited;
        private int count = 0;

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

        void dfs(int a) {
            int m = map[0].length;
            if (!visited[a] && map[a / m][a % m] == 1) {
                visited[a] = true;
                count++;

                for (int b : graph.get(a)) {
                    dfs(b);
                }
            }
        }

        void setMap(int[][] map) {
            this.map = map;
        }

        void countClear() {
            this.count = 0;
        }

        int getNodeCount() {
            return graph.size();
        }

        int getCount() {
            return count;
        }
    }
}
