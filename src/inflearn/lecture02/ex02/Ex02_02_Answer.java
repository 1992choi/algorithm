package inflearn.lecture02.ex02;

import java.util.Arrays;
import java.util.HashMap;

public class Ex02_02_Answer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("aaabc"))); // [0, 2, 2, 3, 3]
        System.out.println(Arrays.toString(solution("aabb"))); // [0, 0, 2, 2, 2]
        System.out.println(Arrays.toString(solution("abcde"))); // [0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(solution("abcdeabc"))); // [0, 0, 0, 1, 1]
        System.out.println(Arrays.toString(solution("abbccddee"))); // [1, 0, 0, 0, 0]
    }

    public static int[] solution(String s) {
        int[] answer = new int[5];

        HashMap<Character, Integer> sH = new HashMap<>();
        for (char x : s.toCharArray()) {
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String tmp = "abcde";
        for (char key : tmp.toCharArray()) {
            if (sH.getOrDefault(key, 0) > max) {
                max = sH.getOrDefault(key, 0);
            }
        }

        for (int i = 0; i < tmp.length(); i++) {
            answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
        }

        return answer;
    }

}
