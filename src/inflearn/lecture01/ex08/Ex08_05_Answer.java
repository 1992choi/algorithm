package inflearn.lecture01.ex08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex08_05_Answer {

    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = in.nextInt();

        DFS(0, 0, arr);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum, Integer[] arr) {
        if (sum > m || answer <= level) {
            return;
        }

        if (sum == m) {
            answer = Math.min(level, answer);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(level + 1, sum + arr[i], arr);
            }
        }
    }

}

