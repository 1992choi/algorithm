package cospro.exam03;

public class Solution04 {

    public int solution(String s1, String s2) {
        int answer = 0;
        String s1Exist = ""; // s1문자열 중 s2에 존재하는 문자
        String s2Exist = ""; // s2문자열 중 s1에 존재하는 문자

        // s1문자열의 끝부분부터 순차적으로 s2에 포함되어있는지 판단
        for (int i = s1.length() - 1; i >= 0; i--) {
            String tmp = "";
            for (int j = i; j < s1.length(); j++) {
                tmp += s1.charAt(j);
            }

            if (s2.contains(tmp)) {
                s1Exist = tmp;
            }
        }

        // s2문자열의 끝부분부터 순차적으로 s1에 포함되어있는지 판단
        for (int i = s2.length() - 1; i >= 0; i--) {
            String tmp = "";
            for (int j = i; j < s2.length(); j++) {
                tmp += s2.charAt(j);
            }

            if (s1.contains(tmp)) {
                s2Exist = tmp;
            }
        }

        answer = s1.length()
                + s2.length()
                - (s1Exist.length() > s2Exist.length() ? s1Exist.length() : s2Exist.length());

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution04 sol = new Solution04();
        String s1 = new String("ababc");
        String s2 = new String("abcdab");
        int ret = sol.solution(s1, s2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }

}
