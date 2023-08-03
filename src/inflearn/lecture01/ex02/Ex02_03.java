package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] arrA = new int[count];
        for (int i = 0; i < count; i++) {
            arrA[i] = in.nextInt();
        }
        int[] arrB = new int[count];
        for (int i = 0; i < count; i++) {
            arrB[i] = in.nextInt();
        }

        solution(count, arrA, arrB);
    }

    public static void solution(int count, int[] arrA, int[] arrB) {
        for (int i = 0; i < count; i++) {
            int result = arrA[i] - arrB[i];
            if (result == 0) {
                System.out.println("D");
            } else if (result == 1 || result == -2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }

}