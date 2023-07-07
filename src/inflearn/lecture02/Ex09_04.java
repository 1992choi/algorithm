package inflearn.lecture02;

import java.util.Arrays;

public class Ex09_04 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(new int[]{1, 4, 3, 5, 7})); //
    }

    public static int solution(int[] param) {
        // i번째와 j번째가 마지막 두항인 등차수열의 최대길이
        int answer = Integer.MIN_VALUE;
        int[][] dy = new int[param.length + 1][param.length + 1];

        // 수월한 계산을 위해 0번째가 아닌 1번째 인덱스부터 활용하도록 재정의
        int[] nums = new int[param.length + 1];
        // 0을 가장 앞게 생성되게 복사를 하려고 했으나, 복사 후 정렬하면 되기 때문에 굳이 System.arraycopy()를 사용할 필요 없을
        // System.arraycopy(param, 0, nums, 1, param.length);
        nums = Arrays.copyOf(param, param.length + 1);

        // 정렬
        Arrays.sort(nums);

        // DP
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // i가 1일 때는 i 앞에 존재하는 숫자가 없으므로 무조건 2자리 숫자 밖에 만들지 못하므로 최대값이 2가 될 수 밖에 없음
                if (i == 1) {
                    dy[i][j] = 2;
                } else {
                    // 공차 계산
                    int diff = nums[j] - nums[i];

                    // i앞에 공차를 만족하는 항목이 있는지 탐색
                    int findIdx = 0;
                    for (int k = 1; k < i; k++) {
                        if (nums[k] == nums[i] - diff) {
                            findIdx = k;
                            break;
                        }
                    }

                    if (findIdx != 0) {
                        dy[i][j] = dy[findIdx][i] + 1; // 이미 최대 길이를 가지고 있는 값(dy[findIdx][i])에 1(j번째 항목)을 더하면 만들 수 있는 등차수열의 최대길이이다.
                    } else {
                        dy[i][j] = 2; // 기본적으로 등차수열의 개수는 2이상이 되므로 2로 셋팅
                    }
                    answer = Math.max(answer, dy[i][j]);
                }
            }
        }

        return answer;
    }

}