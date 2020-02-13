package programers.heap;

//  라면공장
//  https://programmers.co.kr/learn/courses/30/lessons/42629
public class Example2 {
    public static void main(String[] args) {
        int result = solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30);
        System.out.println(result);
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        boolean[] isSupplies = new boolean[supplies.length];
        while (true) {
            if (stock >= k) return answer;
            answer++;

            int reachableDateCount = 0;
            for (int date : dates) {
                if (stock >= date) {
                    reachableDateCount++;
                } else {
                    break;
                }
            }

            int max = 0;
            int index = 0;
            for (int i = 0; i < reachableDateCount; i++) {
                if (!isSupplies[i]) {
                    if (max < supplies[i]) {
                        max = supplies[i];
                        index = i;
                    }
                }
            }

            isSupplies[index] = true;
            stock += max;
        }
    }
}
