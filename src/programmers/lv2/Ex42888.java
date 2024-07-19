package programmers.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv2. 오픈채팅방 - https://school.programmers.co.kr/learn/courses/30/lessons/42888
public class Ex42888 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}))); // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    }

    public static String[] solution(String[] records) {
        // UUID와 사용자 이름 매핑
        int actCount = 0;
        Map<String, String> user = new HashMap<>();
        for (String record : records) {
            String[] words = record.split(" ");
            if (words.length == 3) {
                user.put(words[1], words[2]);
            }

            if ("Enter".equals(words[0]) || "Leave".equals(words[0])) {
                actCount++;
            }
        }

        // 메시지 생성
        String[] answer = new String[actCount];
        actCount = 0;
        for (int i = 0; i < records.length; i++) {
            String[] words = records[i].split(" ");
            if ("Enter".equals(words[0])) {
                answer[actCount++] = user.get(words[1]) + "님이 들어왔습니다.";
            } else if ("Leave".equals(words[0])) {
                answer[actCount++] = user.get(words[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }

}
