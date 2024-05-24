package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 Lv2. 행렬의 곱셈 - https://school.programmers.co.kr/learn/courses/30/lessons/12949
public class Ex12949 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}}))); // [[15, 15], [15, 15], [15, 15]]
        System.out.println(Arrays.deepToString(solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}))); // [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
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
