package doit;

public class Ex004 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {5, 6, 7, 8}}, 2, 2, 3, 4)); // 27
        System.out.println(solution(new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {5, 6, 7, 8}}, 3, 4, 3, 4)); // 6
        System.out.println(solution(new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {5, 6, 7, 8}}, 1, 1, 4, 4)); // 68
    }

    public static int solution(int[][] arr, int x1, int y1, int x2, int y2) {
        int[][] sumArr = new int[arr.length + 1][arr.length + 1]; // 구간합 배열

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sumArr[i + 1][j + 1] = sumArr[i + 1][j] + sumArr[i][j + 1] - sumArr[i][j] + arr[i][j];
            }
        }

        return sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
    }

}
