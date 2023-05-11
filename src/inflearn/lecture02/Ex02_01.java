package inflearn.lecture02;

import java.util.HashMap;
import java.util.Map;

public class Ex02_01 {

    public static void main(String[] args) {
        System.out.println(solution("statitsics"));
        System.out.println(solution("aabb"));
        System.out.println(solution("stringshowtime"));
        System.out.println(solution("abcdeabcdfg"));
    }

    public static int solution(String str) {
        int answer = -1;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            int findValue = map.getOrDefault(str.charAt(i), 0);
            if (findValue == 1) {
                return i + 1;
            }
        }

        return answer;
    }

}
