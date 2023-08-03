package inflearn.lecture02.ex07;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_03_Answer {

    public static void main(String[] args) {
        System.out.println(solution(1, 11)); // 6
        System.out.println(solution(10, 3)); // 3
        System.out.println(solution(1, 34567)); // 19
        System.out.println(solution(5, 6)); // 2
        System.out.println(solution(2, 54321)); // 20
    }

    public static int solution(int s, int e) {
        int[][] ch = new int[2][200001];
        Queue<Integer> Q = new LinkedList<>();
        ch[0][s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int nx : new int[]{x - 1, x + 1, x * 2}) {
                    if (nx >= 0 && nx <= 200000 && ch[L % 2][nx] == 0) {
                        ch[L % 2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            e = e + L;
            if (e > 200000) return -1;
            if (ch[L % 2][e] == 1) return L;
        }
        return -1;
    }

}