package inflearn.lecture02.ex02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Ex02_02 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("aaabc"))); // [0, 2, 2, 3, 3]
        System.out.println(Arrays.toString(solution("aabb"))); // [0, 0, 2, 2, 2]
        System.out.println(Arrays.toString(solution("abcde"))); // [0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(solution("abcdeabc"))); // [0, 0, 0, 1, 1]
        System.out.println(Arrays.toString(solution("abbccddee"))); // [1, 0, 0, 0, 0]
    }

    public static int[] solution(String str) {
        int[] answer = new int[5];

        // 맵에 담기
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 맵에 담긴 값 중 최대값 찾기
        int max = map.values().stream().max(Comparator.naturalOrder()).get().intValue();

        // 같은 빈도수 만들기 : 최대값 - 맵에 담긴 카운트 = 필요한 갯수
        for (int i = 0; i < 5; i++) {
            answer[i] = max - map.getOrDefault((char) (97 + i), 0);
        }

        return answer;
    }

}
