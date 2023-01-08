package inflearn;

import java.util.Scanner;

public class Ex015 {

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
        solution2(count, arrA, arrB);
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

    public static void solution2(int count, int[] arrA, int[] arrB) {
        for (int i = 0; i < count; i++) {
            if (arrA[i] == arrB[i]) {
                System.out.println("D");
            } else if (arrA[i] == 1 && arrB[i] == 3) {
                System.out.println("A");
            } else if (arrA[i] == 2 && arrB[i] == 1) {
                System.out.println("A");
            } else if (arrA[i] == 3 && arrB[i] == 2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }

}