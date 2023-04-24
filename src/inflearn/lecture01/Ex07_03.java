package inflearn.lecture01;

import java.util.Scanner;

public class Ex07_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * solution(n - 1);
        }
    }

}