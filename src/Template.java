import java.util.StringTokenizer;

public class Template {
    public static void main(String[] args) {
//        new int[]{2, 5, 3, 8, 1}, 3, 11
//        new int[]{1,1,2,2}, 2, 3
//        new int[]{1,2,3,2}, 2, 2
        int result = solution(new int[]{1,2,3,2}, 2, 2);

        System.out.println(result);
    }
    public static int solution(int[] arr, int k, int t) {
        int answer = 0;

        for(int i = k; i < arr.length; i++) {
            combination(new int[arr.length], 0, arr.length, i, 0);
            StringTokenizer tokenizer = new StringTokenizer(com, " ");
            while (tokenizer.hasMoreTokens()) {
                String s = tokenizer.nextToken();
                int price = 0;
                for(int j = 0; j < s.length(); j++) {
                    int a = Integer.parseInt(s.substring(j, j + 1));
                    price += arr[a];
                }
                if(price <= t) answer++;
            }
            com = "";
        }

        return answer;
    }

    private static String com = "";

    private static void combination(int[] arr, int index, int n, int r, int target) {
        if (r == 0) print(arr, index);
        else if (target == n) return;
        else {
            arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1);
            combination(arr, index, n, r, target + 1);
        }
    }//end combination()

    private static void print(int[] arr, int length) {
        for (int i = 0; i < length; i++) com += arr[i];
        com += " ";
    }
}
