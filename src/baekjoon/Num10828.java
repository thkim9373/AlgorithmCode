package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// 스택
// https://www.acmicpc.net/problem/10828
public class Num10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int countOfAction = Integer.parseInt(reader.readLine());

        ArrayStack arrayStack = new ArrayStack(countOfAction);

        for (int i = 0; i < countOfAction; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String action = tokenizer.nextToken();

            switch (action) {
                case "push":
                    int input = Integer.parseInt(tokenizer.nextToken());
                    arrayStack.push(input);
                    break;
                case "pop":
                    writer.write(arrayStack.pop() + "\n");
                    break;
                case "size":
                    writer.write(arrayStack.size() + "\n");
                    break;
                case "empty":
                    writer.write(arrayStack.empty() + "\n");
                    break;
                case "top":
                    writer.write(arrayStack.top() + "\n");
                    break;
            }
        }

        reader.close();
        writer.close();
    }

    static class ArrayStack implements StackInterface {
        int index;
        int[] array;

        public ArrayStack(int size) {
            this.array = new int[size];
            this.index = 0;
        }

        @Override
        public void push(int a) {
            array[index++] = a;
        }

        @Override
        public int pop() {
            if (index != 0) {
                return array[--index];
            } else {
                return -1;
            }
        }

        @Override
        public int size() {
            return index;
        }

        @Override
        public int empty() {
            return index != 0 ? 0 : 1;
        }

        @Override
        public int top() {
            return index != 0 ? array[index - 1] : -1;
        }
    }

    interface StackInterface {
        void push(int a);

        int pop();

        int size();

        int empty();

        int top();
    }
}

