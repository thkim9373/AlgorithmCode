package baekjoon;

import java.io.*;
import java.util.Stack;

public class Num4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while (!(input = reader.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }

//            int bracketOpenCount = 0;
//            int bracketCloseCount = 0;
//            int squareBracketOpenCount = 0;
//            int squareBracketCloseCount = 0;

            int squareBracketCountWhenClose = 0;
            int bracketCountWhenClose = 0;

            int bracketCount = 0;
            int squareBracketCount = 0;
            boolean isSafety = false;

            for (int i = 0; i < input.length(); i++) {

                char c = stack.pop();
                if (c == '[') {
                    if (--squareBracketCount < 0 ||
                            bracketCountWhenClose != bracketCount) {
                        break;
                    }
                } else if (c == ']') {
                    bracketCountWhenClose = bracketCount;
                    squareBracketCount++;
                } else if (c == '(') {
                    if (--bracketCount < 0 ||
                            squareBracketCountWhenClose != squareBracketCount) {
                        break;
                    }
                } else if (c == ')') {
                    squareBracketCountWhenClose = squareBracketCount;
                    bracketCount++;
                }


//                if (c == '[') {
//                    if(isCloseInBracket &&
//                            bracketOpenCount != bracketCloseCount) {
//                        isSafety = false;
//                        break;
//                    } else {
//                        isCloseInBracket = false;
//                    }
//
//                    if (++squareBracketOpenCount > squareBracketCloseCount) {
//                        isSafety = false;
//                        break;
//                    }
//                } else if (c == ']') {
//                    if (bracketOpenCount != bracketCloseCount) {
//                        isCloseInBracket = true;
//                    }
//                    squareBracketCloseCount++;
//                } else if (c == '(') {
//                    if(isCloseInSquareBracket &&
//                            squareBracketOpenCount != squareBracketCloseCount) {
//                        isSafety = false;
//                        break;
//                    } else {
//                        isCloseInSquareBracket = false;
//                    }
//
//                    if (++bracketOpenCount > bracketCloseCount) {
//                        isSafety = false;
//                        break;
//                    }
//                } else if (c == ')') {
//                    if (squareBracketOpenCount != squareBracketCloseCount) {
//                        isCloseInSquareBracket = true;
//                    }
//                    bracketCloseCount++;
//
////                    if (squareBracketOpenCount != squareBracketCloseCount) {
////                        isSafety = false;
////                        break;
////                    } else {
////                        bracketCloseCount++;
////                    }
//                }
            }

            if (bracketCount == 0 && squareBracketCount == 0) isSafety = true;

            if (isSafety) {
                writer.write("yse\n");
            } else {
                writer.write("no\n");
            }
        }

        reader.close();
        writer.close();
    }
}
