package fastcampus.codingpackage.part2.ch03;

import java.util.Arrays;
import java.util.Scanner;

/*
    풀이
    - 중복을 허용하기 때문에 Ex15654 문제에서 check 배열로직만 제거하면 될 것처럼 보이지만, 그렇게만 처리하면 시간초과가 발생한다.
      그 이유는 출력이 많아져서 시간초과가 발생하기 때문이다.
      이를 해결하기 위해 System.out.println(); 대신 StringBuilder를 이용하여 한 번에 출력하도록 변경한다.

      - System.out.println()는 호출할 때마다 내부 버퍼를 비우며 출력 작업을 수행하기 때문에 느릴 수 있고,
        반면 StringBuilder는 메모리에서 문자열을 모았다가 한 번에 출력하기 때문에 알고리즘 문제에서는 훨씬 유리하다.
 */
class Ex15656 {
    public static int[] numbers;
    public static int[] output;
    public static boolean[] check;
    public static StringBuilder sb = new StringBuilder();

    public static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }

    public static void perm(int depth, int n, int m) {
        if (depth == m) {
            print(output, m);
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = numbers[i];
            perm(depth + 1, n, m);
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
        perm(0, n, m);
        System.out.println(sb);
    }

}