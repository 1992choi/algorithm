package inflearn.lecture02;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex02_06 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45"))); // ["luis", "daniel"]
        System.out.println(Arrays.toString(solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59"))); // ["john", "bill", "bob"]
        System.out.println(Arrays.toString(solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20"))); // ["cody", "daniel", "tom"]
    }

    public static String[] solution(String[] reports, String times) {
        List<String> answer = new ArrayList<>();

        // 입장 순서대로 정렬
        Arrays.sort(reports, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.split(" ")[1].compareTo(o2.split(" ")[1]);
            }
        });

        // 문서가 사라진 시간에 방문자 추출
        for (String report : reports) {
            // 문서가 사라진 시간
            String from = times.split(" ")[0];
            String to = times.split(" ")[1];
            LocalTime lostFromTime = LocalTime.of(Integer.parseInt(from.split(":")[0]), Integer.parseInt(from.split(":")[1]));
            LocalTime lostToTime = LocalTime.of(Integer.parseInt(to.split(":")[0]), Integer.parseInt(to.split(":")[1]));

            // 방문자
            String name = report.split(" ")[0]; // 직원명
            String time = report.split(" ")[1]; // 이용시간
            LocalTime enterTime = LocalTime.of(Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1]));

            // isAfter()와 isBefore()는 같은 시간은 포함하지 않으므로 equals() 추가하여 비교
            if ((enterTime.isAfter(lostFromTime) && enterTime.isBefore(lostToTime)) || enterTime.equals(lostFromTime) || enterTime.equals(lostToTime)) {
                answer.add(name);
            }
        }

        return answer.toArray(String[]::new);
    }

}
