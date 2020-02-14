package programers.exhaustive_search;

//  카펫
//  https://programmers.co.kr/learn/courses/30/lessons/42842
public class ExhaustiveSearch4 {
    public static void main(String[] args) {
        solution(10, 2);
    }

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];

        boolean isFinish = false;
        for (int n = 3; n < Integer.MAX_VALUE; n++) {
            for (int m = n; m < Integer.MAX_VALUE; m++) {
                if (getBrown(m, n) == brown && getRed(m, n) == red) {
                    answer[0] = m;
                    answer[1] = n;
                    isFinish = true;
                    break;
                } else if (getBrown(m, n) > brown || getRed(m, n) > red) {
                    break;
                }
            }
            if (isFinish) break;
        }

        return answer;
    }

    private static int getBrown(int m, int n) {
        return 2 * (m + n) - 4;
    }

    private static int getRed(int m, int n) {
        return (m - 2) * (n - 2);
    }
}
