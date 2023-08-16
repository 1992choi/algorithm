package inflearn.lecture01.ex02;

import java.util.*;

public class Ex02_08_02 {

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
        Integer[] sortNums = Arrays.copyOf(nums, count);
        Arrays.sort(sortNums, Comparator.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < count; i++) {
            if (map.containsKey(sortNums[i])) {
                rank++;
            } else {
                map.put(sortNums[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.print(map.get(nums[i]) + " ");
        }
    }

}