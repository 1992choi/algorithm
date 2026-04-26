package programmers.codingtest;

import java.util.*;

// 두 개 뽑아서 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class Ex003 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[] {5, 0, 2, 7})));
    }

    public static int[] solution(int[] numbers) {
        Set<Integer> sum = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    sum.add(numbers[i] + numbers[j]);
                }
            }
        }

        int[] answer = new int[sum.size()];
        Iterator<Integer> it = sum.iterator();
        int idx = 0;
        while (it.hasNext()) {
            answer[idx++] = it.next();
        }

        return answer;
    }

}

/*
public static int[] solution(int[] numbers) {
    // ① 중복값 제거를 위한 해시셋 생성
    HashSet Integer> set= new HashSet<>();

    // ② 두 수를 선택하는 모든 경우의 수를 반복문으로 구함
    for (int i = 0; iC numbers.length - 1; it+) {
        for (int j = i + 1; j < numbers.Length; j++) {
            // ③ 두 수를 더한 결과를 해시셋에 추가
            set. add (numbers[i] + numbers[jl);
        }
    }

    // ④ 해시셋의 값을 오름차순 정렬하고 int[] 형태의 배열로 변환하여 반환
    return set.stream) .sorted).mapToInt(Integer:: intValue). toArray();
}
 */