package inflearn.lecture01.ex05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex05_07_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String required = in.next(); // 필수 과목
        String subject = in.next(); // 현수가 선택한 과목

        System.out.println(solution(required, subject));
    }

    public static String solution(String required, String subject) {
        Queue<Character> requiredQueue = new LinkedList<>();

        // 문자열 큐로 변환
        for (char c : required.toCharArray()) {
            requiredQueue.offer(c);
        }

        // 현수가 선택한 과목을 탐색하며, 필수과목이랑 겹치는 과목은 꺼냄.
        for (char c : subject.toCharArray()) {
            if (requiredQueue.size() != 0 && requiredQueue.peek() == c) {
                requiredQueue.poll();
            }
        }

        return requiredQueue.size() == 0 ? "YES" : "NO";
    }

}