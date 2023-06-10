package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

// 프로그래머스 Lv1. 폰켓몬 - https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class Ex1845 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3})); // 2
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4})); // 3
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2})); // 2
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), nums.length / 2);
    }

}
