package programers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

//  다리를 지나는 트럭
//  https://programmers.co.kr/learn/courses/30/lessons/42583
public class Example2 {

    public static void main(String[] args) {
//        100, 100, new int[]{10}
//        100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
//        2, 10, new int[]{7, 4, 5, 6}
        int result = solution(2, 10, new int[]{7, 4, 5, 6});

        System.out.println(result);

        System.out.println(" ");
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;

        Queue<Truck> bridgeQueue = new LinkedList<>();
        Queue<Truck> truckQueue = new LinkedList<>();

        for (int i : truck_weights) {
            truckQueue.offer(new Truck(i, bridge_length));
        }

        int weightOnBridge = 0;
        while (!bridgeQueue.isEmpty() || !truckQueue.isEmpty()) {
            answer++;
            if (!truckQueue.isEmpty() && weightOnBridge + truckQueue.peek().getWeight() <= weight) {
                Truck truck = truckQueue.poll();
                bridgeQueue.offer(truck);
                weightOnBridge += truck.getWeight();
            }
            for (Truck truck : bridgeQueue) {
                truck.setDistance(truck.getDistance() - 1);
            }
            if (!bridgeQueue.isEmpty() && bridgeQueue.peek().getDistance() == 0) {
                Truck truck = bridgeQueue.poll();
                weightOnBridge -= truck.getWeight();
            }
        }

        return answer;
    }

    public static class Truck {
        int weight;
        int distance;

        Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }

        int getWeight() {
            return weight;
        }

        int getDistance() {
            return distance;
        }

        void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
