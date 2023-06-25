package programmers.lv1;

import java.util.*;

// 프로그래머스 Lv1. 실패율 - https://school.programmers.co.kr/learn/courses/30/lessons/42889
public class Ex42889 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}))); // [3,4,2,1,5]
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4}))); // [4,1,2,3]
        System.out.println(Arrays.toString(solution(2, new int[]{1, 1, 1, 1}))); // [1, 2]
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> fail = new HashMap<>();

        // 스테이지별 실패율 구하기
        for (int i = 1; i <= N; i++) {
            int challenger = 0; // 도전자 수
            int failUser = 0; // 실패한 사용자 수
            for (int j = 0; j < stages.length; j++) {
                if (i <= stages[j]) {
                    challenger++;
                }
                if (i == stages[j]) {
                    failUser++;
                }
            }
            fail.put(i, challenger == 0 ? 0 : ((double) failUser / challenger));
        }

        // 실패율 정렬
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(fail.entrySet());
        entryList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            } else {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // 결과반환
        int idx = 0;
        for (Map.Entry<Integer, Double> map : entryList) {
            answer[idx++] = map.getKey();
        }

        return answer;
    }

}
