package programers.graph;

import java.util.ArrayList;
import java.util.List;

//  순위
//  https://programmers.co.kr/learn/courses/30/lessons/49191
public class Example2 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        return answer;
    }

    private static class Graph {
        private List<List<Integer>> node;

        Graph(int n) {
            node = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                node.add(new ArrayList<>());
            }
        }

        void add(int a, int b) {
            node.add()
        }
    }
}
