package inflearn.lecture02;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Ex02_07 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60))); // ["daniel", "john"]
        System.out.println(Arrays.toString(solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120))); // ["daniel", "luis"]
        System.out.println(Arrays.toString(solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70))); // ["bill", "cody"]
        System.out.println(Arrays.toString(solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60))); // ["daniel", "emilly"]
    }

    public static String[] solution(String[] reports, int time) {
        Set<String> answer = new TreeSet<>();

        // 방문자 별로 시간 취합하기
        Map<String, List<String>> reportMap = new HashMap<>();
        for (String report : reports) {
            String employeeName = report.split(" ")[0]; // 방문자 이름
            String employeeTime = report.split(" ")[1]; // 방문자 입출 시간

            // 방문자 이름이 있으면 기존 출입시간 리스트 가져온 후 추가, 없으면 새로 출입시간 기록
            List<String> list = reportMap.containsKey(employeeName) ? reportMap.get(employeeName) : new ArrayList<>();
            list.add(employeeTime);
            reportMap.put(employeeName, list);
        }

        // 방문자별 머무른 시간 계산
        Iterator<Map.Entry<String, List<String>>> iterator = reportMap.entrySet().iterator();
        while (iterator.hasNext()) {
            String employeeName = iterator.next().getKey();
            List<String> values = reportMap.get(employeeName);

            // 입력은 시간 순이 보장되므로 출입시간과 퇴장시간을 하나의 쌍으로 생각하여 index를 2개씩 증가
            long totalSeconds = 0;
            for (int i = 1; i < values.size(); i++) {
                if (i % 2 == 0) {
                    continue;
                }

                LocalTime enter = LocalTime.of(Integer.parseInt(values.get(i - 1).split(":")[0]), Integer.parseInt(values.get(i - 1).split(":")[1]));
                LocalTime exit = LocalTime.of(Integer.parseInt(values.get(i).split(":")[0]), Integer.parseInt(values.get(i).split(":")[1]));
                Duration diff = Duration.between(enter, exit);
                totalSeconds += diff.getSeconds();
            }

            if (totalSeconds / 60 > time) {
                answer.add(employeeName);
            }
        }

        return answer.toArray(String[]::new);
    }

}
