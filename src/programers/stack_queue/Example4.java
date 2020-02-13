package programers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

//  프린터
//  https://programmers.co.kr/learn/courses/30/lessons/42587
public class Example4 {

    public static void main(String[] args) {
//        new int[]{2, 1, 3, 2}, 2
//        new int[]{1,1,9,1,1,1,}, 0
        int result = solution(new int[]{1,1,9,1,1,1,}, 0);

        System.out.println(result);

        System.out.println(" ");
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;

        Queue<Document> documentQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            documentQueue.offer(new Document(i, priorities[i]));
        }

        Queue<Document> printQueue = new LinkedList<>();
        while (!documentQueue.isEmpty()) {
            Document document = documentQueue.poll();

            boolean isHighestPriority = true;
            for (Document d : documentQueue) {
                if (document.priority < d.priority) {
                    isHighestPriority = false;
                    break;
                }
            }

            if (isHighestPriority) {
                printQueue.offer(document);
            } else {
                documentQueue.offer(document);
            }
        }

        for (Document document : printQueue) {
            if (document.index == location) break;
            answer++;
        }

        return answer;
    }

    private static class Document {
        private int index;
        private int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
