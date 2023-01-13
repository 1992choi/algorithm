package inflearn;

import java.util.Scanner;

public class Ex02_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        solution(num);
    }

    public static void solution(int num) {
        int[] arr = new int[num];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < num; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}