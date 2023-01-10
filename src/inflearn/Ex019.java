package inflearn;

import java.util.Scanner;

public class Ex019 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solution(count, nums));
        System.out.println(solution2(count, nums));
    }

    public static int solution(int count, int[] nums) {
        int answer = 0;

        int cumulativeScore = 1;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 1) {
                answer += cumulativeScore;
                cumulativeScore ++;
            } else {
                cumulativeScore = 1;
            }
        }

        return answer;
    }

    public static int solution2(int count, int[] nums) {
        int answer = 0;

        int cumulativeScore = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 1) {
                cumulativeScore++;
                answer += cumulativeScore;
            } else {
                cumulativeScore = 0;
            }
        }

        return answer;
    }

}