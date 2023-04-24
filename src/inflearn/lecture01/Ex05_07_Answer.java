package inflearn.lecture01;

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