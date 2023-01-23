package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex05_07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String required = in.next();
        String hyunsu = in.next();

        System.out.println(solution(required, hyunsu));
    }

    public static String solution(String required, String hyunsu) {
        Queue<Character> requiredQ = new LinkedList<>();
        Queue<Character> hyunsuQ = new LinkedList<>();

        // 필수과목
        for (char c : required.toCharArray()) {
            requiredQ.offer(c);
        }

        // 현수 수업계획
        for (char c : hyunsu.toCharArray()) {
            hyunsuQ.offer(c);
        }

        int count = 0;
        while (!hyunsuQ.isEmpty() && !requiredQ.isEmpty()) {
            char c = hyunsuQ.poll();
            if (requiredQ.peek() == c) {
                requiredQ.poll();
                count++;
            }
        }

        return count == required.length() ? "YES" : "NO";
    }

}