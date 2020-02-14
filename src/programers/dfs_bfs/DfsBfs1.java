package programers.dfs_bfs;

import java.util.*;

public class DfsBfs1 {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        Graph graph = new Graph(n);
        boolean[] visited = new boolean[n];

        for(int i = 0; i < computers.length; i++) {
            int[] computer = computers[i];
            for(int j = i + 1; j < computer.length; j++) {
                if(i != j && computer[j] == 1) graph.add(i, j);
            }
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                graph.dfs(i, visited);
                answer++;
            }
        }

        return answer;
    }

    public static class Graph {
        private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        Graph(int v) {
            for(int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }
        }

        void add(int a, int b) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        void dfs(int a, boolean[] visited) {
            if(!visited[a]) {
                visited[a] = true;

                for(int i : graph.get(a)) {
                    dfs(i, visited);
                }
            }
        }
    }
}
