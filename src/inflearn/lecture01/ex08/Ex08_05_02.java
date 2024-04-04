package inflearn.lecture01.ex08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex08_05_02 {

    static int answer = Integer.MAX_VALUE;
    static Integer[] arr; // 동전 종류
    static int m;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 동전 종류 수
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder()); // Time Limit Exceeded 으로 인하여 추가한 코드
        m = in.nextInt(); // 거슬러 줄 금액

        // 탐색
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int level, int sum) {
        if (sum > m || answer < level) { // Time Limit Exceeded 으로 인하여 추가한 코드 : answer < level
            return;
        }

        if (sum == m) {
            answer = Math.min(answer, level);
        } else {
            for (int i = 0; i < arr.length; i++) {
                dfs(level + 1, sum + arr[i]);
            }
        }
    }

}