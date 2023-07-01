package inflearn.lecture02;

import java.util.*;

public class Ex08_06 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(Arrays.toString(solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}))); // ["math", "music", "art", "physics", "english"]
        System.out.println(Arrays.toString(solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}))); // ["history", "chemistry", "economics", "art"]
        System.out.println(Arrays.toString(solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}))); // ["music", "science", "math", "biology"]
    }

    public static String[] solution(String[] subjects, String[] course) {
        int idx = 0;
        String[] answer = new String[subjects.length];

        // 계산 편의성을 위해 subjects을 key(String) : value(Integer) 형태로 치환
        Map<String, Integer> subjectMap = new HashMap<>();
        for (int i = 0; i < subjects.length; i++) {
            subjectMap.put(subjects[i], i);
        }

        // 진입차수 계산
        int[] indegree = new int[subjects.length];
        for (String c : course) {
            indegree[subjectMap.get(c.split(" ")[0])]++;
        }

        // 위상정렬로 답 구하기
        Queue<Integer> queue = new LinkedList<>();

        // 초기값 셋팅(=진입차수가 0인 것부터 큐에 넣기)
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 위상정렬 시작
        while (!queue.isEmpty()) {
            int pollNum = queue.poll();

            // 큐에서 뺀 값 정답에 넣기
            answer[idx++] = subjects[pollNum];

            // 큐에서 뺀 값과 관련된 진입차수 -1 처리
            for (String c : course) {
                if (c.split(" ")[1].equals(subjects[pollNum])) {
                    indegree[subjectMap.get(c.split(" ")[0])]--;
                    if (indegree[subjectMap.get(c.split(" ")[0])] == 0) {
                        queue.add(subjectMap.get(c.split(" ")[0]));
                    }
                }
            }
        }

        return answer;
    }

}