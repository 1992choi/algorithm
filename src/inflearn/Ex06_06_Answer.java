package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06_06_Answer {

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
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (tmp[i] != arr[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }

}