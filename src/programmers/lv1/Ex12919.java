package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 서울에서 김서방 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/12919
public class Ex12919 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"})); // 김서방은 1에 있다
    }

    public static String solution(String[] seoul) {
//        for (int i = 0; i < seoul.length; i++) {
//            if ("Kim".equals(seoul[i])) {
//                return "김서방은 " + i + "에 있다";
//            }
//        }
//
//        return "";

        return "김서방은 "+ Arrays.asList(seoul).indexOf("Kim") + "에 있다";
    }

}
