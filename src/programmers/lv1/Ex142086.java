package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv1. 가장 가까운 같은 글자 - https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class Ex142086 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana"))); // [-1, -1, -1, 2, 2, 2]
        System.out.println(Arrays.toString(solution("foobar"))); //[-1, -1, 1, -1, -1, -1]
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (characterMap.containsKey(s.charAt(i))) {
                answer[i] = i - characterMap.get(s.charAt(i));
            } else {
                answer[i] = -1;
            }
            characterMap.put(s.charAt(i), i);
        }

        return answer;
    }

}
