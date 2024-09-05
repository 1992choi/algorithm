package programmers.lv2;

import java.util.LinkedHashSet;
import java.util.Set;

// 프로그래머스 Lv2. 모음사전 - https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class Ex84512 {

    public static void main(String[] args) {
        System.out.println(solution("AAAAE")); // 6
        System.out.println(solution("AAAE")); // 10
        System.out.println(solution("I")); // 1563
        System.out.println(solution("EIO")); // 1189
    }

    static String[] words = new String[]{"A", "E", "I", "O", "U"};
    static Set<String> set;

    public static int solution(String word) {
        set = new LinkedHashSet<>();

        for (int i = 0; i < words.length; i++) {
            dfs(0, words[i]);
        }

        // return set.stream().toList().indexOf(word) + 1;
        // 자바14(프로그래머스 환경)에서는 지원하지 않은 문법이라 아래와 같이 작성.

        String[] toStringArray = set.toArray(new String[0]);
        for (int i = 0; i < toStringArray.length; i++) {
            if (toStringArray[i].equals(word)) {
                return i + 1;
            }
        }

        return 0;
    }

    public static void dfs(int level, String addStr) {
        if (level > 4) {
            return;
        }

        set.add(addStr);
        for (int i = 0; i < words.length; i++) {
            dfs(level + 1, addStr + words[i]);
        }
    }

}
