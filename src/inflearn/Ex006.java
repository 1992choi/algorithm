package inflearn;

import java.util.*;

public class Ex006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
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

}