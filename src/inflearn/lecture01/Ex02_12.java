package inflearn.lecture01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex02_12 {

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

}