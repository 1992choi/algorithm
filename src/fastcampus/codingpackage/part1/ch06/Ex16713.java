package fastcampus.codingpackage.part1.ch06;

import java.io.IOException;
import java.util.Scanner;

public class Ex16713 {

    public static void main(String[] args) throws IOException {
        /*
            풀이
            - 각각의 입력값에 대하여 매번 계산을 하면, 시간초과가 발생할 가능성이 높다.
              이 때는 구간에 대한 합을 미리 구한 후에 각각의 입력값에 대한 처리를 하는 것이 효율적이다.
              누적합 배열은 '구간합' 뿐만 아니라 '구간 곱셈', '구간 XOR 연산' 결과도 가능하다.
         */
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        int[] acc = new int[N + 1];
        for (int i = 1; i <= N; i++)
            acc[i] = acc[i - 1] ^ arr[i];

        int ans = 0;
        while (M-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            ans ^= acc[j] ^ acc[i - 1];
        }
        System.out.println(ans);
    }

}