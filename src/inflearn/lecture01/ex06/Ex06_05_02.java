package inflearn.lecture01.ex06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06_05_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, arr));
    }

    public static String solution(int n, int[] arr) {
        // 정렬 후 인접한 값이 동일하면 중복이 있는 것으로 간주
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }

        return "U";
    }

}