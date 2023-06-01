package programmers.lv1;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/*
    프로그래머스 Lv1. 약수의 합
    - https://school.programmers.co.kr/learn/courses/30/lessons/12928
 */
public class Ex12928 {

    public static void main(String[] args) {
        System.out.println(solution(12)); // 28
        System.out.println(solution(5)); // 6
    }

    public static int solution(int n) {
        // 1인 경우는 1 반환
        if (n == 1) {
            return 1;
        }

        // 나뉘어 떨어진 경우, 몫도 약수가 되므로 Set에 나눈 수와 몫을 모두 저장
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n / 2; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }

        return set.stream().flatMapToInt(IntStream::of).sum();
    }

}
