package programmers.lv1;

import java.util.*;

// 프로그래머스 Lv1. 신고 결과 받기 - https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class Ex92334 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution2(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2))); // [2,1,1,0]
        System.out.println(Arrays.toString(solution2(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3))); // [0,0]
    }

    /** 시간초과 */
    public static int[] solution(String[] id_list, String[] report, int k) {
        // 중복 신고 제거
        String[] distinctReport = Arrays.stream(report).distinct().toArray(String[]::new);

        // 신고된 사용자 카운트
        Map<String, Integer> reportCountMap = new HashMap<>();
        for (String str : distinctReport) {
            String reportId = str.split(" ")[1]; // 신고당한 ID
            reportCountMap.put(reportId, reportCountMap.getOrDefault(reportId, 0) + 1);
        }

        // 정지된 사용자 판단 및 신고자에게 메일 발송
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int count = 0;
            for (String s : distinctReport) {
                String userId = s.split(" ")[0]; // 유저 ID
                String reportId = s.split(" ")[1]; // 신고당한 ID

                if (userId.equals(id_list[i]) && reportCountMap.get(reportId) >= k) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    /** 통과 */
    public static int[] solution2(String[] id_list, String[] report, int k) {
        // 중복 신고 제거
        String[] distinctReport = Arrays.stream(report).distinct().toArray(String[]::new);

        // 신고한 유저 매핑 및 신고된 사용자 카운트
        Map<String, List<String>> reportListMap = new HashMap<>(); // 특정 유저가 다른 유저를 신고한 목록
        Map<String, Integer> reportCountMap = new HashMap<>(); // 신고당한 유저의 카운트
        for (String str : distinctReport) {
            String userId = str.split(" ")[0]; // 유저 ID
            String reportId = str.split(" ")[1]; // 신고당한 ID
            reportCountMap.put(reportId, reportCountMap.getOrDefault(reportId, 0) + 1); // 신고당한 유저 카운트 계산

            // 특정 유저가 다른 유저를 신고한 목록 생성
            if (reportListMap.get(userId) == null) {
                List<String> list = new ArrayList<>();
                list.add(reportId);
                reportListMap.put(userId, list);
            } else {
                reportListMap.get(userId).add(reportId);
            }
        }

        // 신고자에게 메일 발송
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            List<String> reportList = reportListMap.get(id_list[i]); // 특정 유저가 신고한 사용자 목록
            int count = 0; // 신고된 유저 숫자
            if (reportList != null) {
                for (String str : reportList) {
                    if (reportCountMap.get(str) >= k) {
                        count++;
                    }
                }
            }
            answer[i] = count;
        }

        return answer;
    }

}
