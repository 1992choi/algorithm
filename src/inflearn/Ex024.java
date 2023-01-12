package inflearn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex024 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int studentCnt = in.nextInt();
        int testCnt = in.nextInt();
        int[][] arr = new int[testCnt][studentCnt];
        for (int i = 0; i < testCnt; i++) {
            for (int j = 0; j < studentCnt; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(studentCnt, testCnt, arr));
        System.out.println(solution2(studentCnt, testCnt, arr));
    }

    public static int solution(int studentCnt, int testCnt, int[][] arr) {
        Set<String> compare = new HashSet<>();

        for (int i = 0; i < testCnt; i++) {
            for (int j = 0; j < studentCnt; j++) {
                for (int k = 0; k < studentCnt; k++) {
                    if (j < k) {
                        compare.add(arr[i][j] + ":" + arr[i][k]);
                    }
                }
            }
        }

        for (int i = 0; i < testCnt; i++) {
            for (int j = 0; j < studentCnt; j++) {
                for (int k = 0; k < studentCnt; k++) {
                    if (j > k) {
                        compare.remove(arr[i][j] + ":" + arr[i][k]);
                    }
                }
            }
        }

        return compare.size();
    }

    public static int solution2(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) pi = s;
                        if (arr[k][s] == j) pj = s;
                    }
                    if (pi < pj) cnt++;
                }
                if (cnt == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

}