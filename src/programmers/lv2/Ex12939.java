package programmers.lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 프로그래머스 Lv2. 최댓값과 최솟값 - https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class Ex12939 {

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4")); // 1 4
        System.out.println(solution("-1 -2 -3 -4")); // -4 -1
        System.out.println(solution("-1 -1")); // -1 -1
    }

    public static String solution(String s) {
        List<Integer> list = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(list);

        return list.get(0) + " " + list.get(list.size() - 1);
    }

}
