package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 Lv2. H-Index - https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class Ex42747 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5})); // 3
        System.out.println(solution(new int[]{3, 3, 3, 4})); // 3
        System.out.println(solution(new int[]{3, 4})); // 2
    }

    // 오답 - 16개 중 마지막 1개 오답.
    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int compareNum = citations[0]; // 비교 대상이 될 수

        for (int i = 0; i < citations.length; i++) {
            int finalCompareNum = compareNum; // Stream에서 compareNum을 바로 사용할 수 없어서 선언
            if (compareNum <= Arrays.stream(citations).filter(x -> x >= finalCompareNum).count()) { // 비교 숫자를 기준으로 비교 숫자만틈 인용되면 H-Index가 된다.
                answer = finalCompareNum;
            }
            compareNum++;
        }

        return answer == 0 ? citations.length : answer; // 조건판단이 끝난 후에 H-Index가 0이라면 H-Index는 논문의 갯수나 다름없다.
    }

}
