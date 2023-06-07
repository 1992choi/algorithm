package programmers.lv1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

// 프로그래머스 Lv1. 두 개 뽑아서 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class Ex68644 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1}))); // [2,3,4,5,6,7]
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7}))); // [2,5,7,9,12]
    }

    public static int[] solution(int[] numbers) {
        // 두 개를 뽑아서 더했을 때, 더한 값이 유일함을 보장하기 위하여 Set 자료구조 사용. 추가적으로 정렬을 위해 HashSet이 아닌 TreeSet 사용
        Set<Integer> answer = new TreeSet<>();

        // 두 수 뽑기
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        // Set을 int[]로 변환하여 반환
        return answer.stream().mapToInt(i -> i).toArray();
    }

}
