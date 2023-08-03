package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_04_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        solution(num);
    }

    public static void solution(int num) {
        int a = 1;
        int b = 1;
        int c;

        System.out.print(a + " " + b + " ");
        for (int i = 2; i < num; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

}