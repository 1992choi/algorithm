package inflearn.lecture01;

import java.util.Scanner;

public class Ex02_08_Answer {

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
        int[] rank = new int[count];
        for (int i = 0; i < count; i++) {
            int cnt = 1;
            for (int j = 0; j < count; j++) {
                if (nums[i] < nums[j]) {
                    cnt++;
                }
            }
            rank[i] = cnt;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(rank[i] + " ");
        }
    }

}