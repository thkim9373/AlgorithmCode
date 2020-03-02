package baekjoon;

public class Base {
    public static String transform(String input) {
        StringBuilder builder = new StringBuilder();
        char lastChar = input.charAt(0);
        builder.append(lastChar);
        for (int i = 1; i < input.length(); i++) {
            if (lastChar != input.charAt(i)) {
                builder.append(input.charAt(i));
                lastChar = input.charAt(i);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Base.transform("abbcbbb"));
    }
}
