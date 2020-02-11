package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//  DFS 와 BFS
//  https://www.acmicpc.net/problem/1260
public class Num1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int v = Integer.parseInt(tokenizer.nextToken());

        Graph graph = new Graph(n, m);

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            graph.add(a, b);
        }
        graph.sort();

        graph.dfsSearch(v);
        graph.visitedClear();

        graph.bfsSearch(v);

        writer.write(graph.getDfsResult() + "\n");
        writer.write(graph.getBfsResult());

        reader.close();
        writer.close();
    }

    private static class Graph {
        private int nV;
        private int nE;
        private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        private boolean[] isVisited;
        private String dfsResult = "";
        private String bfsResult = "";

        Graph(int nV, int nE) {
            this.nV = nV;
            this.nE = nE;
            isVisited = new boolean[nV + 1];
            for (int i = 0; i < nV + 1; i++) {
                graph.add(new ArrayList<>());
            }
        }

        void add(int a, int b) {
            this.graph.get(a).add(b);
            this.graph.get(b).add(a);
        }

        void sort() {
            for (ArrayList<Integer> arrayList : this.graph) {
                Collections.sort(arrayList);
            }
        }

        void visitedClear() {
            for (int i = 0; i < isVisited.length; i++) isVisited[i] = false;
        }

        void dfsSearch(int a) {
            if (!isVisited[a]) {
                isVisited[a] = true;
                dfsResult += a + " ";

                for (int b : this.graph.get(a)) {
                    dfsSearch(b);
                }
            }
        }

        String getDfsResult() {
            return this.dfsResult;
        }

        void bfsSearch(int a) {
            Queue<Integer> queue = new LinkedList<>();
            HashMap<Integer, Boolean> hash = new HashMap<>();

            queue.offer(a);

            while (!queue.isEmpty()) {
                int temp = queue.poll();
                isVisited[temp] = true;
                bfsResult += temp + " ";

                for (int i : graph.get(temp)) {
                    if (!isVisited[i] && !hash.containsKey(i)) {
                        queue.offer(i);
                        hash.put(i, true);
                    }
                }
            }
        }

        String getBfsResult() {
            return this.bfsResult;
        }
    }
}
