package inflearn.lecture02.ex05;

import java.util.*;

public class Ex05_01 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{90, 50, 70, 100, 60}, 140)); // 3
        System.out.println(solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100)); // 5
        System.out.println(solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120)); // 14
    }

    public static int solution(int[] nums, int m) {
        Arrays.sort(nums);

        int answer = 0;
        int lt = 0;
        int rt = nums.length - 1;

        while (lt <= rt) {
            if (nums[lt] + nums[rt] <= m) {
                lt++;
                rt--;
            } else {
                rt--;
            }
            answer++;
        }

        return answer;
    }

}
