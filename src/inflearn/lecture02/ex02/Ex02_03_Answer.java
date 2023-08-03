package inflearn.lecture02.ex02;

import java.util.HashMap;
import java.util.HashSet;

public class Ex02_03_Answer {

    public static void main(String[] args) {
        System.out.println(solution("aaabbbcc")); // 2
        System.out.println(solution("aaabbc")); // 0
        System.out.println(solution("aebbbbc")); // 2
        System.out.println(solution("aaabbbcccde")); // 5
        System.out.println(solution("aaabbbcccdddeeeeeff")); // 8
    }

    public static int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> sH = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();
        for (char x : s.toCharArray()) {
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        for (char key : sH.keySet()) {
            while (ch.contains(sH.get(key))) {
                answer++;
                sH.put(key, sH.get(key) - 1);
            }
            if (sH.get(key) == 0) continue;
            ch.add(sH.get(key));
        }
        return answer;
    }

}
