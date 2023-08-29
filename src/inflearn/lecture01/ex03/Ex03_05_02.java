package inflearn.lecture01.ex03;

import java.util.Scanner;

public class Ex03_05_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int lp = 1;
        int rp = 2;

        while (rp <= n) {
            int sum = 0;
            for (int i = lp; i < rp; i++) {
                sum += i;
            }

            if (sum == n) {
                answer++;
                lp++;
                rp++;
            } else if (sum > n) {
                lp++;
            } else {
                rp++;
            }
        }

        return answer;
    }

}