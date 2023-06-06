package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 최대공약수와 최소공배수 - https://school.programmers.co.kr/learn/courses/30/lessons/12940
public class Ex12940 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12))); // [3, 12]
        System.out.println(Arrays.toString(solution(2, 5))); // [1, 10]
    }

    public static int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[]{gcd, (n * m) / gcd};
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }


}
