package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex02_06 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        solution(count, nums);
    }

    public static void solution(int count, int[] nums) {
        // 자연수 뒤집기
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(new StringBuilder(String.valueOf(nums[i])).reverse().toString());
        }

        // 자연수 중 최대값 구하기(최대값만큼 '에라토스테네스 체'를 미리 계산할 목적)
        int max = Arrays.stream(nums).max().getAsInt();
        int arr[] = new int[max + 1];
        List<Integer> primeList = new ArrayList<>();

        arr[0] = 1; // 0은 판단에서 제외
        arr[1] = 1; // 1은 판단에서 제외
        for (int i = 2; i <= max; i++) {
            if (arr[i] == 0) {
                primeList.add(i);

                // 배수는 모두 1로 만들어서 다음 조건에 만족하지 않도록 만들기
                for (int j = i; j <= max; j += i) {
                    arr[j] = 1;
                }
            }
        }

        // 소수판단
        for (int i = 0; i < count; i++) {
            if (primeList.contains(nums[i])) {
                System.out.print(nums[i] + " ");
            }
        }
    }

}