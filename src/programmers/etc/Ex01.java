package programmers.etc;

import java.util.Arrays;

// 코딩 테스트 합격자 되기 : 05-4
public class Ex01 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3}))); // [-5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4}))); // [1, 1, 2, 2, 3, 4, 5]
        System.out.println(Arrays.toString(solution(new int[]{6, 1, 7}))); // [1, 6, 7]
    }

    public static int[] solution(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

}
