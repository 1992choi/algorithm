package inflearn.lecture01.ex06;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  문제해법 보고 푼 문제.
 */
public class Ex06_09_02 {

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
        // 이분검색
        int lt = Arrays.stream(arr).max().getAsInt(); // 음원을 나눠 담을 수 없으므로 lt는 음원 중 가장 큰 값
        int rt = Arrays.stream(arr).sum(); // 모두 합한 수보다는 작으므로 rt는 주어진 값을 모두 더한 값
        int answer = rt;
        while (lt <= rt) {
            int mid = (rt + lt) / 2;
            int makeCount = make(arr, mid);

            if (makeCount <= m) {
                rt = mid - 1;
                answer = Math.min(mid, answer);
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static int make(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;

        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return cnt;
    }

}