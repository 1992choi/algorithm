package inflearn.lecture02;

import java.util.Arrays;

public class Ex09_04_Answer {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{0, 1, 4, 3, 5, 7})); // 4
        System.out.println(solution(5, new int[]{0, 3, 3, 3, 3, 3})); // 5
    }

    public static int solution(int n, int[] nums) {
        int answer = 0;
        if (n == 1) {
            return 1;
        }
        int[][] dy = new int[n + 1][n + 1];
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                /* 해당 코드 대신 이분검색으로 변경
                    dy[i][j] = 2;
                    int pre = 2 * nums[i] - nums[j];
                    int k = 0;
                    for (k = i - 1; k >= 1; k--) {
                        if (nums[k] == pre) {
                            break;
                        }
                    }
                    dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);
                    answer = Math.max(answer, dy[i][j]);
                */

                dy[i][j] = 2;
                int pre = 2 * nums[i] - nums[j];
                int left = 1;
                int right = i - 1;
                int mid = 0;
                while (left < right) {
                    mid = (left + right) / 2;
                    if (nums[mid] < pre) {
                        left = mid + 1;
                    } else if (nums[mid] == pre && nums[right] == pre) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (nums[right] == pre) {
                    dy[i][j] = Math.max(dy[i][j], dy[right][i] + 1);
                }
                answer = Math.max(answer, dy[i][j]);
            }
        }

        return answer;
    }

}