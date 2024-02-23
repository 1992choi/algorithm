package inflearn.lecture01.ex06;

import java.util.Scanner;

public class Ex06_01_02 {

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
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) { // 가장 작은 숫자의 인덱스 추출
                    idx = j;
                }
            }

            // i와 가장 작은 수와 교체
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}