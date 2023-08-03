package inflearn.lecture01.ex07;

import java.util.Scanner;

public class Ex07_04_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(solution(i) + " ");
        }
    }

    // 메모이제이션 사용안함
    public static int solution(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return solution(n - 2) + solution(n - 1);
        }
    }

}