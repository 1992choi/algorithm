package fastcampus.codingpackage.part2.ch03;

import java.util.Arrays;
import java.util.Scanner;

class Ex15655 {

    public static int[] numbers;
    public static int[] output;
    public static boolean[] check;

    public static void print(int[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    /*
        각 원소들이 오름차순임을 만족하기 위해서는
        - 원소를 오름차순으로 정렬
        - 다음 원소를 나보다 큰 원소부터 탐색할 수 있도록 'i + 1'을 인자값으로 넘겨서, 범위를 0이 아닌 start부터 시작할 수 있도록 설정
     */
    public static void perm(int depth, int n, int m, int start) {
        if (depth == m) {
            print(output, m);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = numbers[i];
                perm(depth + 1, n, m, i + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        numbers = new int[n];
        output = new int[m];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        perm(0, n, m, 0);
    }

}