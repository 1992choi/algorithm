package inflearn.lecture01.ex07;

import java.util.Scanner;

public class Ex07_03_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return recursion(n);
    }

    public static int recursion(int n) {
        if (n == 0) {
            return 1;
        }

        return n * recursion(n - 1);
    }

}