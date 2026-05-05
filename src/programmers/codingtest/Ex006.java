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

/*
public int[] solution(int N, int[] stages) {
    // ❶ 스테이지별 도전자 수를 구함
    int[] challenger = new int[N + 2];
    for (int i = 0; i < stages.length; i++) {
        challenger[stages[i]] += 1;
    }

    // ❷ 스테이지별 실패한 사용자 수 계산
    HashMap<Integer, Double> fails = new HashMap<>();
    double total = stages.length;

    // ❸ 각 스테이지를 순회하며, 실패율 계산
    for (int i = 1; i <= N; i++) {
        if (challenger[i] == 0) { // ❹ 도전한 사람이 없는 경우, 실패율은 0
            fails.put(i, 0.);
        }
        else {
            fails.put(i, challenger[i] / total); // ❺ 실패율 구함
            total -= challenger[i]; // ❻ 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
        }
    }

    // ❼ 실패율이 높은 스테이지부터 내림차순으로 정렬
    return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
}
 */