package inflearn.lecture01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex02_08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Integer[] nums = new Integer[count];

        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        solution(count, nums);
    }

    public static void solution(int count, Integer[] nums) {
        Integer[] rank = new Integer[count];
        Integer[] sortedNums = Arrays.copyOf(nums, count);
        Arrays.sort(sortedNums, Collections.reverseOrder());

        int currentRank = 1; // 현재 등수
        int cumulativeNum = 1; // 동률 수
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (sortedNums[i] == nums[j]) {
                    rank[j] = currentRank;
                    cumulativeNum++;

                    /*
                        등수가 배정된 학생은 점수를 음수로 변경.
                        -> 점수가 동일한 경우가 있는 경우, 등수가 재배정될 수 있음.
                     */
                    nums[j] = -1;
                }
            }
            currentRank = cumulativeNum;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(rank[i] + " ");
        }
    }

}