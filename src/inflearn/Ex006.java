package inflearn;

import java.util.*;

public class Ex006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    public static String solution(String str) {
        String answer = "";
        Set<Character> set = new HashSet<>();

        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (set.contains(ch)) {
                continue;
            }

            answer += String.valueOf(ch);
            set.add(ch);
        }

        return answer;
    }

    public static String solution2(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            /*
                i는 현재 문자의 위치,
                str.indexOf(str.charAt(i))는 해당 문자가 최초로 발견된 위치

                현재 문자의 위치와 최초로 발견된 위치가 다르다면, 중복된 문자라는 뜻
             */
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }

}