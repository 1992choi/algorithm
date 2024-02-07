package inflearn.lecture01.ex05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex05_07_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String need = in.next();
        String plan = in.next();

        System.out.println(solution(need, plan));
    }

    public static String solution(String need, String plan) {
        Queue<Character> queue = new LinkedList<>();
        for (char x : need.toCharArray()) {
            queue.offer(x);
        }

        for (char x : plan.toCharArray()) {
            /*
                판단하려는 과목이 필수과목에는 존재하지만 현재 큐의 첫 번째가 아니라면, 이미 순서를 어긴 케이스이므로 "NO"로 리턴
                Ex) C B A (필수과목)
                    C D K A E 가 주어졌을 때,
                    A를 판단할 차례이면,

                    B A (필수과목)
                    A E 상태이다.
                    A는 필수과목이지만 B 뒤에 존재(=큐의 첫번째가 아닌 경우)하므로, 순서가 이미 깨진 상황이다.
             */
            if (queue.contains(x)) {
                if (x != queue.poll()) {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

}