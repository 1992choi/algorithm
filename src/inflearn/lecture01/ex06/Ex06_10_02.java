package inflearn.lecture01.ex06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제해법 보고 푼 문제.
 */
public class Ex06_10_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, c, arr));
    }

    public static int solution(int n, int c, int[] arr) {
        int answer = 0;

        // 수직선상의 마구간 좌표 정렬
        Arrays.sort(arr);

        // 이분 검색
        int lt = 1; // arr[0];으로 하면 안되는 이유 : arr이 5, 8, 12, 14로 주어지고 선택값이 5(v), 8(v), 12(v), 14면, 5와 8사이에 값이 3인데 arr[0]으로 초기화를 하면 5가 되므로 3을 찾을 수 없는 조건이 되어버린다.
        int rt = arr[n - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 두 말의 거리

            // 가장 처음 좌표부터 배치시켜야 유리하기 때문에 0번째 인덱스에 무조건 들어간다고 가정
            int ep = arr[0]; // 바로 직전에 말을 배치한 좌표값
            int count = 1; // 배치한 말의 수
            for (int i = 1; i < n; i++) {
                if (arr[i] - ep >= mid) { // 현재 마구간의 좌표와 직전에 말을 배치한 마구간의 좌표의 거리가 기준 거리를 만족하는지 판단
                    count++;
                    ep = arr[i];
                }
            }

            if (count < c) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }

}