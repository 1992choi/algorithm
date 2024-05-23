package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

// 프로그래머스 Lv2. 연속 부분 수열 합의 개수 - https://school.programmers.co.kr/learn/courses/30/lessons/131701
public class Ex131701 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 1, 1, 4})); // 18
    }

    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k <= j + i; k++) {
                    sum += elements[k % elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }

}
