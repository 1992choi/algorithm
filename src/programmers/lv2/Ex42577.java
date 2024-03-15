package programmers.lv2;

import java.util.*;

// 프로그래머스 Lv2. 전화번호 목록 - https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class Ex42577 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"})); // false
        System.out.println(solution(new String[]{"123", "456", "789"})); // true
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"})); // false
    }

    public static boolean solution(String[] phone_book) {
        // 전화번호 셋팅
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(phone_book));

        // 조건판단
        for (String phone : phone_book) {
            // 자기 자신을 문자열을 첫 번째 알파벳부터 하나씩 늘려가며 Set에 존재하는지 확인
            for (int i = 1 ; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

}
