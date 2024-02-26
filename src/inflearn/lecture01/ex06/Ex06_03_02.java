package inflearn.lecture01.ex06;

import java.util.Scanner;

public class Ex06_03_02 {

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
            int tmp = arr[i]; // i를 기준 값으로 놓기
            int idx = i; // i가 위치할 인덱스

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) { // 기준값(=i) 보다 큰 경우, 뒤로 한 칸씩 밀기
                    arr[j + 1] = arr[j];
                    idx--;
                }
            }

            arr[idx] = tmp; // 한 칸씩 밀고 남은 칸에 i 넣기
        }

        // print
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}