package programers.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Num4 {
    public static void main(String[] args) {

        String[] result = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});

        for (String s : result) {
            System.out.print(s + " ");
        }

        System.out.println(" ");
    }

    public static String[] solution(String[][] tickets) {
        String[] answer;

        List<String> airports = new ArrayList<>();
        for (String[] ticket : tickets) {
            for (String nation : ticket) {
                if (!nation.equals("ICN") && !airports.contains(nation)) {
                    airports.add(nation);
                }
            }
        }
        Collections.sort(airports);

        String[] allAirports = new String[airports.size() + 1];
        allAirports[0] = "ICN";
        for (int i = 1; i < allAirports.length; i++) {
            allAirports[i] = airports.get(i - 1);
        }

        int n = allAirports.length;
        Graph graph = new Graph(n);

        for (String[] ticket : tickets) {
            int a = -1, b = -1;
            String start, end;
            start = ticket[0];
            end = ticket[1];
            for (int j = 0; j < allAirports.length; j++) {
                if (allAirports[j].equals(start)) a = j;
                if (allAirports[j].equals(end)) b = j;
            }

            graph.add(a, b);
        }

        int[] visited = new int[tickets.length + 1];
        Arrays.fill(visited, -1);
        visited[0] = 0;
        graph.dfs(visited, 0);

        answer = new String[n];
        for (int i = 0; i < visited.length; i++) {
            answer[i] = allAirports[visited[i]];
        }

        return answer;
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
        }

        void dfs(int[] visited, int a) {
            for(int i = 0; i < visited.length - 1; i++) {
                int b = graph.get(a).get(0);
                visited[i + 1] = b;
                graph.get(a).remove(0);
                a = b;
            }
        }
    }
}
