package inflearn.lecture01.ex05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex05_06_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // 왕자 셋팅
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 번호 외치기
        int count = 1;
        while (queue.size() != 1) {
            int tmp = queue.poll(); // 번호 외치기 (=왕자 꺼냄)
            if (count == k) { // 외친 번호가 k이면 해당 왕자는 탈락
                count = 1;
            } else { // 살아남은 왕자는 다시 큐로 넣어서 계속 진행
                queue.add(tmp);
                count++;
            }
        }

        return queue.poll();
    }

}
