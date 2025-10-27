package fastcampus.codingpackage.part1.ch08;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2230 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        // 수열을 정렬해야 두 포인터로 차이를 효율적으로 계산할 수 있음
        Arrays.sort(arr);

        // 가능한 최댓값으로 초기화 (가장 큰 수 - 가장 작은 수)
        int ansDiff = arr[N - 1] - arr[0];

        // 투 포인터 중 오른쪽 포인터
        int rightIndex = 0;

        // 왼쪽 포인터를 하나씩 이동시키면서 조건을 만족하는 최소 차이를 찾는다
        for (int leftIndex = 0; leftIndex < N; leftIndex++) {

            // 오른쪽 포인터를 이동시켜 arr[rightIndex] - arr[leftIndex] >= M을 만족시키기
            // 단, 배열의 끝을 넘지 않도록 주의
            while (arr[rightIndex] - arr[leftIndex] < M && rightIndex < N - 1)
                rightIndex++;

            // 현재 두 수의 차이 계산
            int diff = arr[rightIndex] - arr[leftIndex];

            // 차이가 M 이상이면, 그 중 최소값을 갱신
            if (diff >= M) ansDiff = Math.min(ansDiff, diff);
        }

        // 결과 출력
        System.out.println(ansDiff);
    }

}
