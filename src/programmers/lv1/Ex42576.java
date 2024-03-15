package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv1. 완주하지 못한 선수 - https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class Ex42576 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"})); // leo
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"})); // vinko
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})); // mislav
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 참가자 추가
        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        // 완주자 제외
        for (String person : completion) {
            map.put(person, map.get(person) - 1);
        }

        for (String person : map.keySet()) {
            if (map.get(person) == 1) {
                return person;
            }
        }

        return null;
    }

}
