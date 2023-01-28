package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        solution(n, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void solution(int n, int[] arr) {
        if (n == 2) {
            return;
        } else {
            solution(n - 1, arr);
            arr[n - 1] = arr[n - 3] + arr[n - 2];
        }
    }

}