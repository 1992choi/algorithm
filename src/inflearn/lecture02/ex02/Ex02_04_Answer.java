package inflearn.lecture02.ex02;

import java.util.HashMap;

public class Ex02_04_Answer {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5)); // 5
        System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5)); // 5
        System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2}, 3)); // 6
        System.out.println(solution(new int[]{-1, 0, 1}, 0)); // 2
        System.out.println(solution(new int[]{-1, -1, -1, 1}, 0)); // 1
    }

    public static int solution(int[] nums, int m) {
        int answer = 0;
        HashMap<Integer, Integer> nH = new HashMap<>();
        int sum = 0;
        nH.put(0, 1);
        for (int x : nums) {
            sum += x;
            if (nH.containsKey(sum - m)) answer += nH.get(sum - m);
            nH.put(sum, nH.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

}
