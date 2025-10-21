package fastcampus.codingpackage.part1.ch07;

import java.util.Scanner;

public class Ex1654 {

    public static void main(String[] args) {
        // 시간초과
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[k];

        int sum = 0; // 가지고 있는 랜선의 총 개수
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int answer = 0;
        int cutLength = sum / n; // 자를 랜선의 길이 (가지고 있는 랜선의 총 길이를 필요한 갯수로 나누기 : 각각의 랜선이 얼마의 길이만큼씩 필요한지 파악하기 위함.)

        while (cutLength > 0) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                count += arr[i] / cutLength; // 각 랜선을 기준이 되는 랜선 길이로 잘랐을 때의 갯수 누적
            }

            if (count >= n) { // 기준 갯수를 만족하면 정답에 누적
                answer = Math.max(answer, cutLength);
            }

            cutLength--;
        }

        System.out.println(answer);
    }

}

/*
    풀이
    - 시간초과를 해결하기 위하여 이분탐색으로 접근을 했어야함.


    static int calculateCount(int[] lengths, long cutLength) {
        int cnt = 0;
        for (int l : lengths)
            cnt += l / cutLength;
        return cnt;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] len = new int[K];
        for (int i = 0; i < K; i++)
            len[i] = sc.nextInt();

        long l = 1, r = (1L << 31) - 1, ans = -1;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (calculateCount(len, m) >= N) { // 해당 길이의 랜선을 N개 이상 만들 수 있다면 길이를 늘려본다.
                ans = m;
                l = m + 1;
            } else { // N개 이상 만들 수 없다면 길이를 줄여본다.
                r = m - 1;
            }
        }
        System.out.println(ans);
    }
 */