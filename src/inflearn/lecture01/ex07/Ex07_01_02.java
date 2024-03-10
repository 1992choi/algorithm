package inflearn.lecture01.ex07;

import java.util.Scanner;

public class Ex07_01_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    public static void solution(int n) {
        recursion(n, 1);
    }

    public static void recursion(int n, int num) {
        if (num > n) {
            return;
        }
        System.out.print(num + " ");
        recursion(n, ++num);
    }

}