package programers.cacao.Years2020;

//  [2020카카오공채] 문자열 압축
//  https://programmers.co.kr/learn/courses/30/lessons/60057
public class Example1 {

    public static void main(String[] args) {
        int result = solution("aabbaccc");

        System.out.println(result);
    }

    public static int solution(String s) {
        int answer = s.length();

        int splitLength = 1;
        while (splitLength <= s.length() / 2) {

            String zippedString = s;
            for(int i = 0; i < s.length() - splitLength + 1; i += splitLength) {
                String token = s.substring(i, i + splitLength);

                int count = 1;
                for (int j = i + splitLength; j < s.length() - splitLength + 1; j += splitLength) {
                    if (s.substring(j, j + splitLength).equals(token)) {
                        count++;
                        i += splitLength;
                    } else {
                        break;
                    }
                }

                if (count > 1) {
                    String zipToken = "";
                    for (int j = 0; j < count; j++) {
                        zipToken += token;
                    }

                    zippedString = zippedString.replace(zipToken, count + token);
                }
            }

            answer = Math.min(answer, zippedString.length());

            splitLength++;
        }

        return answer;
    }
}
