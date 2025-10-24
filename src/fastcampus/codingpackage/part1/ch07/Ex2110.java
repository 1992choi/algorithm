package fastcampus.codingpackage.part1.ch07;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2110 {

    static int calculateCount(int[] xs, int distance) {
        int pastX = xs[0]; // 직전에 공유기를 설치한 집. xs[0]으로 초기화하는 이유는 첫 집에 공유기를 설치하는 것이 가장 유리하기 때문에 첫 집은 무조건 설치함.
        int cnt = 1; // 첫 집에 설치했기 때문에 1로 초기화.
        for (int i = 1; i < xs.length; i++) {
            if (xs[i] - pastX >= distance) { // 현재 집과 이전 집의 거리가 기준치 보다 같거나 클 경우에만 공유기 설치 가능
                pastX = xs[i];
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] xs = new int[N];
        for (int i = 0; i < N; i++)
            xs[i] = sc.nextInt();

        Arrays.sort(xs);

        int l = 1; // 공유기 사이의 최소거리. 0은 같은 집에 2개를 놓는 것이므로 불가능. 따라서 1이 최소값
        int r = xs[N - 1] - xs[0]; // 최대거리는 첫 집과 마지막 집. 문제에서 공유기는 최소 2개가 주어지기 때문
        int ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (calculateCount(xs, m) >= C) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println(ans);
    }

}
