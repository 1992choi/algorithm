package inflearn.lecture01.ex06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06_08_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        // 오름차순 정렬
        Arrays.sort(arr);

        // 이분검색
        int lt = 0;
        int rt = n - 1;
        while (lt < rt) {
            if (m == arr[(rt + lt) / 2]) {
                return (rt + lt) / 2 + 1;
            } else if (arr[(rt + lt) / 2] > m) {
                rt = (rt + lt) / 2;
            } else {
                lt = (rt + lt) / 2;
            }
        }

        return -1;
    }

}