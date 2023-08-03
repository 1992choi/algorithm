package inflearn.lecture01.ex08;

import java.util.Scanner;

public class Ex08_01_Answer {

    static String answer = "NO";
    static int n = 0;
    static int total = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            total += arr[i];
        }

        DFS(0, 0, arr);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum, int[] arr) {
        if (flag) {
            return;
        }

        if (sum > total / 2) {
            return;
        }

        if (level == n) {
            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(level + 1, sum + arr[level], arr);
            DFS(level + 1, sum, arr);
        }
    }

}

