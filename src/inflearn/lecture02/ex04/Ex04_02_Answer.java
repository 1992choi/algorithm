package inflearn.lecture02.ex04;

import java.util.Arrays;
import java.util.HashMap;

public class Ex04_02_Answer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 10, 2, 3, 5, 6}))); // [1, 3, 5]
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14}))); // [1, 1, 3, 7]
        System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14}))); // [2, 3, 5, 5, 7, 7]
        System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14, 1, 2}))); // [1, 2, 3, 5, 5, 7, 7]
    }

    public static int[] solution(int[] nums) {
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> nH = new HashMap<>();
        for (int x : nums) nH.put(x, nH.getOrDefault(x, 0) + 1);
        Arrays.sort(nums);
        int idx = 0;
        for (int x : nums) {
            if (nH.get(x) == 0) continue;
            answer[idx] = x;
            idx++;
            nH.put(x, nH.get(x) - 1);
            nH.put(x * 2, nH.get(x * 2) - 1);
        }
        return answer;
    }

}
