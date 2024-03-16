package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 프로그래머스 Lv2. 가장 큰 수 - https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class Ex42746 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2})); // 6210
        System.out.println(solution(new int[]{3, 30, 34, 5, 9})); // 9534330
        System.out.println(solution(new int[]{0, 0, 0})); // 0
    }

    public static String solution(int[] numbers) {
        if (Arrays.stream(numbers).boxed().max(Comparator.naturalOrder()).get() == 0) {
            return "0";
        }

        List<String> list = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.toList());
        String answer = "";

        list.sort((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;

            if (s1.equals(s2)) {
                return 0;
            } else if (Long.parseLong(s1) >= Long.parseLong(s2)) {
                return -1;
            } else {
                return 1;
            }
        });

        // 문자열 결합
        for (String number : list) {
            answer += number;
        }

        return answer;
    }

}
