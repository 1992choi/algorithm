package programmers.lv2;

// 프로그래머스 Lv2. JadenCase 문자열 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Ex12951 {

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me")); // 3people Unfollowed Me
        System.out.println(solution("for the last week")); // For The Last Week
        System.out.println(solution("  for the what 1what  ")); //   For The What 1what
    }

    public static String solution(String s) {
        String answer = "";

        char beforeChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (beforeChar == ' ' && Character.isAlphabetic(currentChar)) {
                answer += Character.toUpperCase(currentChar);
            } else {
                answer += Character.toLowerCase(currentChar);
            }

            beforeChar = currentChar;
        }

        return answer;
    }

}
