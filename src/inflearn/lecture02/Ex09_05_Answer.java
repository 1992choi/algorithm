package inflearn.lecture02;

public class Ex09_05_Answer {

    public static void main(String[] args) {
        // 0번째 인덱스의 값인 0은 1부터 인덱스를 사용하기 위해 임의로 추가한 값
        System.out.println(solution(5, new int[]{0, 1, 2, 3, 4, 2})); // 2
    }

    public static int solution(int n, int[] nums) {
        int[][] dy = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (nums[j] == nums[(j + i)]) {
                    dy[j][j + i] = dy[j + 1][j + i - 1];
                } else {
                    dy[j][j + i] = Math.min(dy[j][j + i - 1], dy[j + 1][j + i]) + 1;
                }
            }
        }

        return dy[1][n];
    }

}