package goorm;

import java.util.Scanner;

// 단어 필터
public class Ex174760 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next(); // 사용자 메시지
        String e = sc.next(); // 필터링할 단어(=사용자 메시지에서 없애고자하는 문자열)

        // 필터링 시작
        String answer = e.replace(s, "");

        while (e.contains(s)) {
            e = e.replace(s, "");
            answer = e;
        }

        System.out.println(answer.isEmpty() ? "EMPTY" : answer);
    }

}