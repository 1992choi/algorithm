package inflearn.lecture02;

import java.util.HashMap;

public class Ex02_01_Answer {

    public static void main(String[] args) {
        System.out.println(solution("statitsics"));
        System.out.println(solution("aabb"));
        System.out.println(solution("stringshowtime"));
        System.out.println(solution("abcdeabcdfg"));
    }

    public static int solution(String s) {
        HashMap<Character, Integer> sH = new HashMap<>();
        for (char x : s.toCharArray()) {
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (sH.get(s.charAt(i)) == 1) return i + 1;
        }
        return -1;
    }

}
