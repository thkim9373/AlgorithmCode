package programers.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//  기능개발
//  https://programmers.co.kr/learn/courses/30/lessons/42586
public class Example3 {

    public static void main(String[] args) {
        int[] result = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});

        System.out.println(Arrays.toString(result));

        System.out.println(" ");
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;

        Queue<Project> projectQueue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            projectQueue.offer(new Project(progresses[i], speeds[i]));
        }

        Queue<Integer> resultQueue = new LinkedList<>();
        while (!projectQueue.isEmpty()) {
            for (Project project : projectQueue) {
                project.work();
            }
            int serviceCount = 0;
            while (!projectQueue.isEmpty() && projectQueue.peek().isFinish()) {
                projectQueue.poll();
                serviceCount++;
            }
            if (serviceCount != 0) resultQueue.offer(serviceCount);
        }

        answer = new int[resultQueue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultQueue.poll();
        }

        return answer;
    }

    public static class Project {
        private int progresses;
        private int speeds;

        public Project(int progresses, int speeds) {
            this.progresses = progresses;
            this.speeds = speeds;
        }

        void work() {
            this.progresses += speeds;
        }

        boolean isFinish() {
            return progresses >= 100;
        }
    }
}
