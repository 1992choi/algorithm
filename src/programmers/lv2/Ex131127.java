package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv2. 할인 행사 - https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class Ex131127 {

    public static void main(String[] args) {
        System.out.println(
                solution(
                        new String[]{"banana", "apple", "rice", "pork", "pot"},
                        new int[]{3, 2, 2, 2, 1},
                        new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
                )
        ); // 3

        System.out.println(
                solution(
                        new String[]{"apple"},
                        new int[]{10},
                        new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}
                )
        ); // 0

        System.out.println(
                solution(
                        new String[]{"banana", "apple", "rice", "pork", "pot"},
                        new int[]{3, 2, 2, 2, 1},
                        new String[]{"apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana", "chicken", "apple"}
                )
        ); // 3
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        // 할인 품목 담기
        int i;
        for (i = 0; i < (Math.min(discount.length, 10)); i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }

        if (discount.length > 10) { // 할인 날짜가 10일보다 큰 경우
            // 살 수 있는 제품 파악(최초 셋팅하고 판단).
            if (check(want, number, map)) {
                answer++;
            }

            for (int j = i; j < discount.length; j++) {
                // 할인이 끝난 상품 제거
                map.put(discount[j - 10], map.getOrDefault(discount[j - 10], 0) - 1);

                // 할인이 시작되는 상품 추가
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);

                // 살 수 있는 제품 파악
                if (check(want, number, map)) {
                    answer++;
                }
            }
        } else { // 할인 날짜가 10일 이하인 경우
            // 살 수 있는 제품 파악
            if (check(want, number, map)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean check(String[] want, int[] number, Map<String, Integer> map) {
        int cnt = 0; // 살 수 있는 제품
        for (int j = 0; j < want.length; j++) {
            if (number[j] <= map.getOrDefault(want[j], 0)) {
                cnt++;
            }
        }

        if (cnt == want.length) { // 살 수 있는 제품을 모두 산 케이스
            return true;
        } else {
            return false;
        }
    }

}
