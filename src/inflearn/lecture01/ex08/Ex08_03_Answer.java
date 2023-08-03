package inflearn.lecture01.ex08;

import java.util.Scanner;

public class Ex08_03_Answer {

    static int answer = Integer.MIN_VALUE;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int[] a = new int[n]; // 점수
        int[] b = new int[n]; // 걸리는 시간
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }

        DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum, int totalTime, int[] score, int[] time) {
        if (totalTime > m) {
            return;
        }

        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(level + 1, sum + score[level], totalTime + time[level], score, time);
            DFS(level + 1, sum, totalTime, score, time);
        }
    }

}