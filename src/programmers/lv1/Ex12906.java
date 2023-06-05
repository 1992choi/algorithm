package programmers.lv1;

import java.util.*;

// 프로그래머스 Lv1. 같은 숫자는 싫어 - https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Ex12906 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1}))); // [1,3,0,1]
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 4, 3, 3}))); // [4,3]
    }

    public static int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int prevNum = -1;
        for (int num : arr) {
            if (prevNum != num) {
                answer.add(num);
            }
            prevNum = num;
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }

}
