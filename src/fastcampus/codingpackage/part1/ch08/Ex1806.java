package fastcampus.codingpackage.part1.ch08;

import java.util.Scanner;

public class Ex1806 {

    public static void main(String[] args) {
        // 시간초과
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        int lt = 0;
        int rt = 0;

        while (rt < n) {
            int sum = 0;
            for (int i = lt; i <= rt; i++) {
                sum += arr[i];
            }

            if (sum == s) {
                answer = Math.min(answer, rt - lt + 1);
                lt++;
                rt++;
            } else if (sum < s) {
                rt++;
            } else {
                answer = Math.min(answer, rt - lt + 1);
                lt++;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

}

/*
    풀이

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 수열 길이, M: 목표 합
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 수열 입력
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        // 최소 길이를 저장할 변수 (최대값으로 초기화)
        int ansLength = N + 1;

        // 투포인터 우측 포인터 역할, 부분합 누적 변수
        int nextIndex = 0;
        int currentSum = 0;

        // 왼쪽 포인터 i를 하나씩 이동하며 최소 길이 탐색
        for (int i = 0; i < N; i++) {

            // 현재 부분합이 목표보다 작으면, 우측 포인터를 증가시키며 합 누적
            while (currentSum < M && nextIndex < N)
                currentSum += arr[nextIndex++];

            // 목표합 이상이 되면 최소 길이 갱신
            // nextIndex - i: 현재 구간 [i, nextIndex-1] 길이
            if (currentSum >= M) ansLength = Math.min(ansLength, nextIndex - i);

            // 왼쪽 포인터 이동 전, arr[i]를 부분합에서 제거
            // 다음 루프에서 구간이 i+1부터 시작되도록 함
            currentSum -= arr[i];
        }

        // 최소 길이를 찾지 못한 경우 (합이 M 이상인 구간 없음)
        if (ansLength > N) ansLength = 0;

        System.out.println(ansLength);
    }
 */