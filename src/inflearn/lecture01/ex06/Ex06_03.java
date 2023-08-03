package inflearn.lecture01.ex06;

import java.util.Scanner;

public class Ex06_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(n, arr);
    }

    public static void solution(int n, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int idx = i;
            int tmp = arr[i];

            while ((idx > 0) && (arr[idx - 1] > tmp)) {
                arr[idx] = arr[idx - 1];
                idx--;
            }

            arr[idx] = tmp;
        }

        // print
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}