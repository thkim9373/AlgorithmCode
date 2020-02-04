package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// 덩치
// https://www.acmicpc.net/problem/7568
public class Num7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfPersons = Integer.parseInt(reader.readLine());
        People[] peoples = new People[numOfPersons];

        for (int i = 0; i < numOfPersons; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int height = Integer.parseInt(tokenizer.nextToken());
            peoples[i] = new People(weight, height, 1);
        }

        for (int i = 0; i < numOfPersons - 1; i++) {
            People a = peoples[i];

            for (int j = i; j < numOfPersons; j++) {
                People b = peoples[j];

                if (a.getWeight() < b.getWeight() && a.getHeight() < b.getHeight()) {
                    a.setGrade(a.getGrade() + 1);
                } else if (a.getWeight() > b.getWeight() && a.getHeight() > b.getHeight()) {
                    b.setGrade(b.getGrade() + 1);
                }
            }
        }

        for (People people : peoples) {
            writer.write(people.getGrade() + " ");
        }

        reader.close();
        writer.close();
    }

    static class People {
        int weight;
        int height;
        int grade;

        People(int weight, int height, int grade) {
            this.weight = weight;
            this.height = height;
            this.grade = grade;
        }

        int getWeight() {
            return weight;
        }

        int getHeight() {
            return height;
        }

        int getGrade() {
            return grade;
        }

        void setGrade(int grade) {
            this.grade = grade;
        }
    }
}
