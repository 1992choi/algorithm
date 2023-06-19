package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 덧칠하기 - https://school.programmers.co.kr/learn/courses/30/lessons/161989
public class Ex161989 {

    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[]{2, 3, 6})); // 2
        System.out.println(solution(5, 4, new int[]{1, 3})); // 1
        System.out.println(solution(4, 1, new int[]{1, 2, 3, 4})); // 4
        System.out.println(solution(5, 2, new int[]{1, 4, 5})); // 2
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        int leftIdx = Arrays.stream(section).min().getAsInt(); // 한 번의 터치로 칠할 수 있는 범위의 시작점
        int rightIdx = leftIdx + m - 1;  // 한 번의 터치로 칠할 수 있는 범위의 끝점

        while (leftIdx <= n) {
            // 좌측부터 우측 범위까지 페인팅
            for (int i = 0; i < section.length; i++) {
                if (leftIdx <= section[i] && section[i] <= rightIdx) {
                    section[i] = 0;
                }
            }
            answer++;

            if (Arrays.stream(section).allMatch(x -> x == 0)) { // 모두 칠해졌다면 종료
                break;
            } else { // 아직 칠할 구간이 남았다면 범위 재조정
                leftIdx = Arrays.stream(section).filter(x -> x != 0).min().getAsInt();
                rightIdx = leftIdx + m - 1;
            }
        }

        return answer;
    }

    public static int solution2(int n, int m, int[] section) {
        int roller = section[0];
        int cnt = 1;
        for (int i = 1; i < section.length; i++) {
            if (roller + m - 1 < section[i]) {
                cnt++;
                roller = section[i];
            }
        }
        return cnt;
    }

}
