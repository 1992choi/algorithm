package inflearn.lecture02;

import java.util.Arrays;

public class Ex04_01_Answer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

    public static int[] solution(int[] nums) {
        int[] answer = new int[nums.length];
        int[][] res = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            int tmp = nums[i];
            while (tmp > 0) {
                cnt += (tmp % 2);
                tmp = tmp / 2;
            }
            res[i][0] = nums[i];
            res[i][1] = cnt;
        }
        Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < res.length; i++) {
            answer[i] = res[i][0];
        }
        return answer;
    }

}
