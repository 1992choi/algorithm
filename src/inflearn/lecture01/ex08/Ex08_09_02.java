package inflearn.lecture01.ex08;

import java.util.Scanner;

public class Ex08_09_02 {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] isUse;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        isUse = new boolean[n];

        // 조합 구하기(=n개에서 m개 뽑기)
        dfs(0, 0);
    }

    public static void dfs(int level, int startNum) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = startNum; i < n; i++) {
                if (!isUse[i]) {
                    isUse[i] = true;
                    arr[level] = (i + 1);
                    dfs(level + 1, i + 1);
                    isUse[i] = false;
                }
            }
        }
    }

}