package inflearn.lecture01.ex06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06_06_02 {

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
        int[] rightArr = Arrays.copyOf(arr, n); // 올바르게 번호가 배정되었을 때의 배열
        Arrays.sort(rightArr);

        for (int i = 0; i < n; i++) {
            if (arr[i] != rightArr[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }

}