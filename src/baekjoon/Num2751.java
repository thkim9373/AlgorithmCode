package baekjoon;

import java.io.*;

// 수 정렬하기 2
// https://www.acmicpc.net/problem/2751
public class Num2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrLength = Integer.parseInt(reader.readLine());
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        mergeSort(arr, 0, arr.length - 1);

        StringBuilder builder = new StringBuilder();

        for (int a : arr) builder.append(a).append("\n");

        writer.write(builder.toString());

        reader.close();
        writer.close();
    }

    /********************************************************************
     * Shell sort
     * https://gmlwjd9405.github.io/2018/05/08/algorithm-shell-sort.html
     ********************************************************************/
    private static void shellSort(int[] arr, int arrLength) {
        int temp, k, gap;

        gap = arrLength / 2;
        if (gap % 2 == 0) gap++;

        while (gap > 0) {

            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arrLength; j += gap) {
                    temp = arr[j];

                    for (k = j - gap; k >= 0 && temp < arr[k]; k -= gap) {
                        arr[k + gap] = arr[k];
                    }

                    arr[k + gap] = temp;
                }
            }

            if (gap == 1) break;
            gap /= 2;
            if (gap % 2 == 0) gap++;
        }
    }


    /********************************************************************
     * Quick sort
     * https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html
     ********************************************************************/
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);

            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    // 해당 링크에서는 임의의 pivot 값을 index 0 로 선택했으나,
    // 백준 사이트에서 worst case 가 있는 탓인지 시간 초과가 나와서 pivot 을 가운뎃 값으로 결정하도록 변경
    // https://coding-god.tistory.com/94
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left < right) {
            while ((arr[left] < pivot) && (left < right)) left++;
            while ((arr[right] > pivot) && (left < right)) right--;

            if (left < right) {
                swap(arr, left, right);
            }
        }
        return left;
    }


    /********************************************************************
     * Heap sort
     * https://gmlwjd9405.github.io/2018/05/10/algorithm-heap-sort.html
     * https://ratsgo.github.io/data%20structure&algorithm/2017/09/27/heapsort/
     ********************************************************************/
    private static void heapSort(int[] arr) {
        int length = arr.length;

        for (int i = length / 2; i >= 0; i--) {
            heapify(arr, i, length);
        }
        for (int i = length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int parentNodeIndex, int heapSize) {
        int largest = parentNodeIndex;
        int leftNodeIndex = parentNodeIndex * 2 + 1;
        int rightNodeIndex = parentNodeIndex * 2 + 2;

        if (leftNodeIndex < heapSize && arr[largest] < arr[leftNodeIndex]) {
            largest = leftNodeIndex;
        }
        if (rightNodeIndex < heapSize && arr[largest] < arr[rightNodeIndex]) {
            largest = rightNodeIndex;
        }

        if (largest != parentNodeIndex) {
            swap(arr, largest, parentNodeIndex);
            heapify(arr, largest, heapSize);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    /********************************************************************
     * Merge sort
     * https://gmlwjd9405.github.io/2018/05/08/algorithm-merge-sort.html
     ********************************************************************/
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static int[] sortedArr = new int[1000000];

    private static void merge(int[] arr, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sortedArr[k++] = arr[i++];
            } else {
                sortedArr[k++] = arr[j++];
            }
        }

        if (i > mid) {
            for (int l = j; l <= right; l++) {
                sortedArr[k++] = arr[l];
            }
        } else {
            for (int l = i; l <= mid; l++) {
                sortedArr[k++] = arr[l];
            }
        }

        if (right + 1 - left >= 0) System.arraycopy(sortedArr, left, arr, left, right + 1 - left);
    }
}
