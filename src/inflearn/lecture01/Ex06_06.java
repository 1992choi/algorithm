package inflearn.lecture01;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06_06 {

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
        int[] origin = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (origin[i] != arr[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }

}