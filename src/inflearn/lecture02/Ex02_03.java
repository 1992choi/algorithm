package inflearn.lecture02;

import java.util.*;
import java.util.stream.Collectors;

public class Ex02_03 {

    public static void main(String[] args) {
        System.out.println(solution("aaabbbcc")); // 2
        System.out.println(solution("aaabbc")); // 0
        System.out.println(solution("aebbbbc")); // 2
        System.out.println(solution("aaabbbcccde")); // 5
        System.out.println(solution("aaabbbcccdddeeeeeff")); // 8
    }

    public static int solution(String str) {
        int answer = 0;

        // 맵에 담기
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 리스트로 변환 후 오름차순 정렬
        List<Integer> values = map.values().stream().collect(Collectors.toList());
        Collections.sort(values);

        // 중복이 없어질 때까지 문자 하나씩 제거하기
        while (!isUnique(values)) {
            answer += removeDupMinValue(values);
        }

        return answer;
    }

    public static boolean isUnique(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == 0) { // 값이 0이면 문자가 제거된 것으로 간주
                continue;
            }

            // 오름차순 정렬이므로 현재 값과 다음 값이 같으면 중복이 존재
            if (list.get(i).equals(list.get(i + 1))) {
                return false;
            }
        }

        return true;
    }

    public static int removeDupMinValue(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == 0) { // 값이 0이면 문자가 제거된 것으로 간주
                continue;
            }

            // 오름차순 정렬이므로 현재 값과 다음 값이 같으면 중복이 존재하므로 카운트 감소시키기 (= 문자빼는 행위대신 카운트 감소)
            if (list.get(i).equals(list.get(i + 1))) {
                list.set(i, list.get(i) - 1);
                return 1;
            }
        }

        return 0;
    }

}
