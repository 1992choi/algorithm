package inflearn;

import java.util.Scanner;

public class Ex08_07_Answer {

    static int[][] dy = new int[35][35];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();

        System.out.println(DFS(n, r));
    }

    public static int DFS(int n, int r) {
        if (dy[n][r] > 0) { // 메모이제이션 사용
            return dy[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
            return dy[n][r];
        }
    }

}

