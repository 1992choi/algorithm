package inflearn.lecture02;

import java.util.Arrays;

public class Ex05_02_Answer {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 5, 3, 4, 2, 3})); // 4
        System.out.println(solution(new int[]{2, 3, 4, 5})); // 3
        System.out.println(solution(new int[]{3, 3, 3, 3, 3})); // 5
        System.out.println(solution(new int[]{1, 1, 3, 5})); // 2
        System.out.println(solution(new int[]{1, 1, 1, 2, 5})); // 2
    }

    public static int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= 5) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }

}