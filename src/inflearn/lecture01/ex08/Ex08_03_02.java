package inflearn.lecture01.ex08;

import java.util.Scanner;

public class Ex08_03_02 {

    static int answer = Integer.MIN_VALUE;
    static int n; // 문제 개수
    static int m; // 제한 시간
    static int[][] arr; // 원소
    static boolean[] check; // 원소 선택 여부

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt(); // 점수
            arr[i][1] = in.nextInt(); // 걸린 시간
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
            int sumScore = 0; // 점수 합
            int sumTime = 0; // 걸린 시간
            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    sumScore += arr[i][0];
                    sumTime += arr[i][1];
                }
            }

            if (m >= sumTime) {
                answer = Math.max(answer, sumScore);
            }
        } else {
            check[level] = false;
            dfs(level + 1);

            check[level] = true;
            dfs(level + 1);
        }
    }

}