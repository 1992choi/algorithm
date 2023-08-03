package inflearn.lecture02.ex06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Ex06_05 {

    public static void main(String[] args) {
        // TODO: 2023/06/14. 종료조건 다시 확인할 것. 종료조건 때문에 실패하는 테스트케이스 존재함.
        System.out.println(Arrays.toString(solution("2025505"))); // ["20.25.50.5","20.255.0.5","202.5.50.5","202.55.0.5"]
        System.out.println(Arrays.toString(solution("0000"))); // ["0.0.0.0"]
        System.out.println(Arrays.toString(solution("255003"))); // ["25.50.0.3","255.0.0.3"]
        System.out.println(Arrays.toString(solution("155032012"))); // []
        System.out.println(Arrays.toString(solution("02325123"))); // ["0.23.25.123", "0.23.251.23", "0.232.5.123", "0.232.51.23"]
        System.out.println(Arrays.toString(solution("121431211"))); // ["1.214.31.211", "12.14.31.211", "12.143.1.211", "12.143.12.11", "12.143.121.1", "121.4.31.211", "121.43.1.211", "121.43.12.11", "121.43.121.1"]
    }

    static Set<String> answer;
    static int level;
    static int[] check;

    public static String[] solution(String s) {
        // IP는 4개의 파트로 나뉘어서 구성되는데 각 파트는 최대 3자리 이므로 12를 넘으면 유효한 IP가 아님 (제한사항을 고려해볼 때 16자리까지 들어올 수 있음)
        if (s.length() > 12) {
            return new String[]{};
        }

        answer = new HashSet<>();
        level = s.length();
        check = new int[s.length()];

        dfs(1, 1, 1, s);

        return answer.toArray(String[]::new);
    }

    public static void dfs(int group1, int group2, int group3, String s) {
        if (group1 + group2 + group3 >= s.length() - 1) {
            int group4 = s.length() - group1 - group2 - group3;
            if (group4 < 1) { // IP패턴이 올바르지 않음(=앞의 3그룹에서 모든 숫자를 사용했으므로 마지막 그룹에서는 사용할 숫자가 없음)
                return;
            }

            String group1Str = s.substring(0, group1);
            String group2Str = s.substring(group1, group1 + group2);
            String group3Str = s.substring(group1 + group2, group1 + group2 + group3);
            String group4Str = s.substring(group1 + group2 + group3, group1 + group2 + group3 + group4);
            if (Pattern.matches("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])([.](?!$)|$)){4}", (group1Str + "." + group2Str + "." + group3Str + "." + group4Str))) {
                answer.add(group1Str + "." + group2Str + "." + group3Str + "." + group4Str);
            }
        } else {
            /*
                IP패턴은 000.000.000.000이며, 000에는 한 자리부터 최대 3자리까지 구성이 가능하다.
                즉, 숫자 조합의 관점을 보는 것이 아니라 구간을 나눌 수 있는 경우를 판단하는 식으로 접근했다.
            */
            dfs(group1 + 1, group2, group3, s);
            dfs(group1, group2 + 1, group3, s);
            dfs(group1, group2, group3 + 1, s);
        }
    }

}