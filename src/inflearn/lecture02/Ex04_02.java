package inflearn.lecture02;

import java.util.Arrays;

public class Ex04_02 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 10, 2, 3, 5, 6}))); // [1, 3, 5]
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14}))); // [1, 1, 3, 7]
        System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14}))); // [2, 3, 5, 5, 7, 7]
        System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14, 1, 2}))); // [1, 2, 3, 5, 5, 7, 7]
    }

    public static int[] solution(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    continue;
                }

                // 2배가 된 값은 0으로 지워버림
                if (nums[i] * 2 == nums[j]) {
                    nums[j] = 0;
                    break;
                }
            }
        }

        return Arrays.stream(nums).filter(x -> x != 0).toArray();
    }

}
