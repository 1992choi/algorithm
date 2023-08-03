package inflearn.lecture02.ex09;

import java.util.Scanner;

public class Ex09_02_Answer {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int D = kb.nextInt();
        int P = kb.nextInt();
        int[] dy = new int[D + 1];
        for (int i = 0; i < P; i++) {
            int L = kb.nextInt();
            int C = kb.nextInt();
            for (int j = D; j > L; j--) {
                if (dy[j - L] == 0) {
                    continue;
                }
                dy[j] = Math.max(dy[j], Math.min(dy[j - L], C));
            }
            dy[L] = Math.max(dy[L], C);
        }

        /*
            - 입력예제
                7 6
                4 5
                3 6
                2 7
                1 4
                6 7
                1 5
         */
        System.out.println(dy[D]);
    }
}