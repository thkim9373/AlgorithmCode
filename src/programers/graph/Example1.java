package programers.graph;

import java.util.*;

//  가장 먼 노드
//  https://programmers.co.kr/learn/courses/30/lessons/49189
public class Example1 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    private static int[] distanceArr;

    public static int solution(int n, int[][] edge) {
        int answer = 1;

        distanceArr = new int[n];
        Arrays.fill(distanceArr, -1);

        Graph graph = new Graph(n);
        for (int[] i : edge) {
            graph.add(i[0], i[1]);
        }
        graph.bfs();

        Arrays.sort(distanceArr);
        int max = distanceArr[distanceArr.length - 1];
        for (int i = distanceArr.length - 2; i >= 0; i--) {
            if (distanceArr[i] == max) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    private static class Graph {
        private List<List<Integer>> node;

        Graph(int n) {
            node = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                node.add(new ArrayList<>());
            }
        }

        void add(int a, int b) {
            this.node.get(a - 1).add(b - 1);
            this.node.get(b - 1).add(a - 1);
        }

        Queue<Integer> nodeQueue = new LinkedList<>();

        void bfs() {
            distanceArr[0] = 0;
            int temp = 0;
            List<Integer> nodes = this.node.get(temp);
            for (int i : nodes) {
                distanceArr[i] = distanceArr[temp] + 1;
                nodeQueue.offer(i);
            }

            while (!nodeQueue.isEmpty()) {
                temp = nodeQueue.poll();
                nodes = this.node.get(temp);
                for (int i : nodes) {
                    if (distanceArr[i] == -1) {
                        distanceArr[i] = distanceArr[temp] + 1;
                        nodeQueue.offer(i);
                    }
                }
            }
        }
    }
}
