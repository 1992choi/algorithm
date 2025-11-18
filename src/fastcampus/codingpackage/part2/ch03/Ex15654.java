package fastcampus.codingpackage.part2.ch03;

import java.util.Arrays;
import java.util.Scanner;

class Ex15654 {

    public static int[] numbers;
    public static int[] output;
    public static boolean[] check;

    public static int n;
    public static int m;

    public static void perm(int depth) {
        // base case : 재귀를 끝내는 영역
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        // recursive case : 재귀영역
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = numbers[i];
                perm(depth + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        output = new int[m];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        perm(0);
    }
}