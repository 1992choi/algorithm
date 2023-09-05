package inflearn.lecture01.ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Ex04_04_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();

        System.out.println(solution(s, t));
    }

    public static int solution(String s, String t) {
        int answer = 0;

        // 기준 문자열 T에 대한 처리
        int tLength = t.length();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // S단어와의 비교
        for (int i = 0; i <= s.length() - tLength; i++) {
            Map<Character, Integer> sMap = new HashMap<>();
            String curStr = s.substring(i, i + t.length());
            for (int j = 0; j < tLength; j++) {
                sMap.put(curStr.charAt(j), sMap.getOrDefault(curStr.charAt(j), 0) + 1);
            }

            boolean isValid = true;
            for (int j = 0; j < tLength; j++) {
                if (!Objects.equals(tMap.get(t.charAt(j)), sMap.get(t.charAt(j)))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                answer++;
            }
        }

        return answer;
    }

}
