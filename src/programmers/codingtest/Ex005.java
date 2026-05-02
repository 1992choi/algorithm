package programmers.codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 행렬의 곱셈 - https://school.programmers.co.kr/learn/courses/30/lessons/12949
public class Ex005 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}})));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Row = arr1.length;
        int arr1Col = arr1[0].length;
        int arr2Col = arr2[0].length;
        int[][] answer = new int[arr1Row][arr2Col];

        for (int i = 0; i < arr1Row; i++) {
            for (int j = 0; j < arr2Col; j++) {
                for (int k = 0; k < arr1Col; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

}

/*
public int[][] solution(int[][] arr1, int[][] arr2) {
    // ① 행렬 크기
    int r1 = arr1.length;
    int c1 = arr1[0].length;
    int c2 = arr2[0].length;

    // ② 결과 행렬
    int[][] answer = new int[r1][c2];

    // ③ 행렬 곱셈
    for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c2; j++) {
            for (int k = 0; k < c1; k++) {
                answer[i][j] += arr1[i][k] * arr2[k][j];
            }
        }
    }

    return answer;
}
 */