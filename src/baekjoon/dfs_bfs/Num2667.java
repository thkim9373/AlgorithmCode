package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//  단지번호붙이기
//  https://www.acmicpc.net/problem/2667
public class Num2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String mapRow = reader.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapRow.substring(j, j + 1));
            }
        }

        Graph graph = new Graph(n * n);
        graph.setMap(map);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1) {
                    graph.add(i * n + j, i * n + j + 1);
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1) {
                    graph.add(i * n + j, (i + 1) * n + j);
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

        Collections.sort(resultList);
        writer.write(resultList.size() + "\n");
        for (int i : resultList) {
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
            if (!visited[a] && map[a / map.length][a % map.length] == 1) {
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
