package programmers.codingtest;

import java.util.Arrays;

// 실패율 - https://school.programmers.co.kr/learn/courses/30/lessons/42889
public class Ex006 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] count = new int[N + 2];

        // ① 각 스테이지에 머물러 있는 사람 수 카운팅
        for (int s : stages) {
            count[s]++;
        }

        int total = stages.length;

        // ② [실패율, 스테이지] 저장
        double[][] fail = new double[N][2];

        for (int i = 1; i <= N; i++) {

            double failure = 0;

            if (total != 0) {
                failure = (double) count[i] / total;
            }

            fail[i - 1][0] = failure;
            fail[i - 1][1] = i;

            // 핵심: 다음 스테이지로 갈 때 사람 수 감소
            total -= count[i];
        }

        // ③ 정렬 (실패율 desc, 스테이지 asc)
        Arrays.sort(fail, (a, b) -> {
            if (a[0] == b[0]) {
                return (int) (a[1] - b[1]);
            }
            return Double.compare(b[0], a[0]);
        });

        // ④ 결과 추출
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) fail[i][1];
        }

        return answer;
    }

}