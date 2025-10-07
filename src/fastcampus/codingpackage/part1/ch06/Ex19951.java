package fastcampus.codingpackage.part1.ch06;

import java.io.IOException;
import java.util.Scanner;

public class Ex19951 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int h = sc.nextInt();

            for (int j = a - 1; j <= b - 1; j++) {
                arr[j] = arr[j] + h;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

/*
    풀이
    - 위 방식대로 하면 시간 초과 발생.
      - 구간합을 이용하여 시간복잡도를 낮춘다.
    - delta 배열
      - a ~ b 구간의 변화량을 기록한다.
        - 1 ~ 5 구간에 -3을 작업한다고 가정하면,
          (1부터 끝까지 -3을 작업) + (5부터 끝까지 +3을 작업)하는 것과 동일하다. (원래 작업 구간은 1~5를 -3 하는 것인데, 1~끝까지 -3을 했으므로 5부터 +3을 해서 작업을 하지 않은 것과 동일하게 맞춰야 한다.)
    - accDelta 배열
      - 각 지시별로 구한 변화량을 누적한 배열


    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] origin = new int[N + 1];
    for (int i = 1; i <= N; i++)
        origin[i] = sc.nextInt();

    int[] delta = new int[N + 2];
    while (M-- > 0) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();

        // 각 지시의 변화량을 기록
        delta[a] += k;
        delta[b + 1] -= k;
    }

    // 각 변화량을 누적한 값 기록
    int[] accDelta = new int[N + 1];
    for (int i = 1; i <= N; i++)
        accDelta[i] = accDelta[i - 1] + delta[i];

    // 원래 높이에 변화량 적용
    for (int i = 1; i <= N; i++)
        System.out.print(origin[i] + accDelta[i] + " ");
    System.out.println();
 */