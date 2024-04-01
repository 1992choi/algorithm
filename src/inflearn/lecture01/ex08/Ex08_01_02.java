package inflearn.lecture01.ex08;

import java.util.Scanner;

public class Ex08_01_02 {

    static String answer = "NO";
    static int n; // 원소 개수
    static int[] arr; // 원소
    static boolean[] check; // 원소 선택 여부

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // 원소 선택 여부를 위한 배열 생성
        check = new boolean[n];

        // 탐색
        solution();
        System.out.println(answer);
    }

    public static void solution() {
        dfs(0);
    }

    public static void dfs(int level) {
        if (level == n) {
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0 ; i < n; i++) {
                if (check[i]) {
                    leftSum += arr[i];
                } else {
                    rightSum += arr[i];
                }
            }

            if (leftSum == rightSum) {
                answer = "YES";
            }
        } else {
            check[level] = false;
            dfs(level + 1);

            check[level] = true;
            dfs(level + 1);
        }
    }

}