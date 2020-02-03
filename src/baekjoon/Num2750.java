package baekjoon;

import java.io.*;

// 수 정렬하기
// https://www.acmicpc.net/problem/2750
public class Num2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalCount = Integer.parseInt(reader.readLine());
        int[] arr = new int[totalCount];

        for (int i = 0; i < totalCount; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        insertionSort(arr, totalCount);

        for (int i = 0; i < totalCount; i++) writer.write(arr[i] + "\n");

        reader.close();
        writer.close();
    }

    // https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html
    private static void insertionSort(int[] arr, int totalCount) {
        int j, temp;
        for (int i = 1; i < totalCount; i++) {
            temp = arr[i];

            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = temp;
        }
    }

    // https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html
    private static void selectionSort(int[] arr, int totalCount) {
        int temp, leastIndex;
        for (int i = 0; i < totalCount - 1; i++) {
            leastIndex = i;

            for (int j = i + 1; j < totalCount; j++) {
                if (arr[leastIndex] > arr[j]) {
                    leastIndex = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[leastIndex];
            arr[leastIndex] = temp;
        }
    }

    // https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html
    private static void bubbleSort(int[] arr, int totalCount) {
        int temp;
        for (int i = totalCount - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
