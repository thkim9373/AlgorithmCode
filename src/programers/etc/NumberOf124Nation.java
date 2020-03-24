package programers.etc;

public class NumberOf124Nation {
    public static void main(String[] args) {
        System.out.println(solution(6));
    }

    public static String solution(int n) {
        String answer;

        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int rest = n % 3;
            n /= 3;
            if (rest == 0) {
                rest = 4;
                n -= 1;
            }
            builder.append(rest);
        }
        answer = builder.reverse().toString();

        return answer;
    }
}
