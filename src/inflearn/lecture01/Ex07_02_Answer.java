package inflearn.lecture01;

import java.util.Scanner;

public class Ex07_02_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    public static void solution(int n) {
        if (n == 0) {
            return;
        } else {
            solution(n / 2);
            System.out.print(n % 2 + " ");
        }
    }

}