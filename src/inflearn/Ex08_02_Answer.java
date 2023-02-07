package inflearn;

import java.util.Scanner;

public class Ex08_02_Answer {

    static int c;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        c = in.nextInt();
        n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        DFS(0, 0, arr);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum, int[] arr) {
        if (sum > c) {
            return;
        }

        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(level + 1, sum + arr[level], arr);
            DFS(level + 1, sum, arr);
        }
    }

}

