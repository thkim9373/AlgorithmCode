package programers.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//  라면공장
//  https://programmers.co.kr/learn/courses/30/lessons/42629
public class Example3 {
    public static void main(String[] args) {
        int result = solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        int time = 0;

        Queue<Job> jobQueue = new PriorityQueue<>();
        for (int[] j : jobs) {
            jobQueue.offer(new Job(j[0], j[1]));
        }

        List<Job> jobList = new ArrayList<>();

        while (!jobQueue.isEmpty()) {
            jobList.add(jobQueue.poll());
        }


        while (!jobList.isEmpty()) {
            boolean isPlay = false;
            for (int i = 0; i < jobList.size(); i++) {
                Job job = jobList.get(i);
                if (job.requestTime <= time) {
                    time += job.getDuration();
                    answer += time - job.requestTime;
                    jobList.remove(job);
                    isPlay = true;
                    break;
                }
            }

            if (!isPlay) time++;
        }

        return answer / jobs.length;
    }

    public static class Job implements Comparable<Job> {
        private int requestTime;
        private int duration;

        Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }

        @Override
        public int compareTo(Job o) {
            if (getDuration() < o.getDuration()) {
                return -1;
            } else if (getDuration() == o.getDuration()) {
                if (requestTime < o.requestTime) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }

        int getDuration() {
            return duration;
        }
    }
}
