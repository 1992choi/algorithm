package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_04_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        solution(num);
    }

    public static void solution(int num) {
        int[] nums = new int[num];
        nums[1] = nums[0] = 1;

        for (int i = 2; i < num; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}