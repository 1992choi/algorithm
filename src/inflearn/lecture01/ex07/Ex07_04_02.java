package inflearn.lecture01.ex07;

import java.util.Scanner;

public class Ex07_04_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(solution(i) + " ");
        }
    }

    public static int solution(int n) {
        return recursion(n);
    }

    public static int recursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return recursion(n - 2) + recursion(n - 1);
        }
    }

}