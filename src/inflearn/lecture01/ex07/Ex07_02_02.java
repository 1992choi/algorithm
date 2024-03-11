package inflearn.lecture01.ex07;

import java.util.Scanner;

public class Ex07_02_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    public static void solution(int n) {
        recursion(n);
    }

    public static void recursion(int n) {
        if (n == 0) {
            return;
        }

        recursion(n / 2);
        System.out.print(n % 2);
    }

}