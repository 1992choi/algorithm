package inflearn.lecture02;

import java.util.Arrays;

public class Ex04_03 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2)); // 28
        System.out.println(solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2)); // 34
        System.out.println(solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3)); // 60
        System.out.println(solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3)); // 283
        System.out.println(solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3)); // 129
    }

    public static int solution(int[] nums, int k) {
        int answer = 0;

        // 정렬
        Arrays.sort(nums);

        // 현수와 영희가 한 번씩 카드를 가져간다고 했을 때, 라운드 당 카드 점수 차이 계산
        int[] diff = new int[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            diff[i] = nums[i * 2 + 1] - nums[i * 2];
        }

        // 점수 차이 정렬
        Arrays.sort(diff);

        // 현수 점수 합산
        for (int i = 0; i < nums.length / 2; i++) {
            answer += nums[i * 2];
        }

        // 높은 점수 차이가 나는 라운드 바꿨을 떄의 값 누적하기
        for (int i = 0; i < k; i++) {
            answer += diff[diff.length - 1 - i];
        }

        return answer;
    }

}
