package inflearn.lecture02.ex06;

import java.util.*;
import java.util.stream.Collectors;

public class Ex06_04 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("aaaabb"))); // ['baaaab', 'aabbaa', 'abaaba']
        System.out.println(Arrays.toString(solution("abbcc"))); // ["bcacb","cbabc"]
        System.out.println(Arrays.toString(solution("abbccee"))); // ["bceaecb","becaceb","cbeaebc","cebabec","ebcacbe","ecbabce"]
        System.out.println(Arrays.toString(solution("abbcceee"))); // []
        System.out.println(Arrays.toString(solution("ffeffaae"))); // ["ffeaaeff", "fefaafef", "effaaffe", "ffaeeaff", "fafeefaf", "affeeffa", "feaffaef", "efaffafe", "faeffeaf", "afeffefa", "eaffffae", "aeffffea"]
    }

    static List<String> list;
    static Set<String> answer;
    static int[] ch;
    static int level;

    public static String[] solution(String s) {
        // 알파벳이 홀수개인게 2개 이상이면 빈 값 리턴(= 대칭을 만들 수 없으므로)
        Map<String, Integer> map = new HashMap<>();
        for (String tmp : s.split("")) {
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        if (map.values().stream().filter(x -> x % 2 == 1).count() > 1) {
            return new String[]{};
        }

        // 데이터 초기화
        answer = new HashSet<>();
        list = new ArrayList<>();
        ch = new int[s.length()];
        level = s.length();

        // DFS 시작
        String[] arr = s.split("");
        dfs(0, arr);
        return answer.toArray(String[]::new);
    }

    public static void dfs(int l, String[] arr) {
        if (l == level) {
            // 리스트[한 문자씩 담겨져있는 상태]를 스트링으로 변환
            String tmpStr = list.stream().map(String::valueOf).collect(Collectors.joining());

            // 대칭문자인지 비교
            for (int i = 0; i < tmpStr.length() / 2; i++) {
                if (tmpStr.charAt(i) != tmpStr.charAt(tmpStr.length() - 1 - i)) {
                    return;
                }
            }

            // 대칭문자만 담기
            answer.add(tmpStr);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    list.add(arr[i]);
                    dfs(l + 1, arr);
                    ch[i] = 0;
                    list.remove(list.size() - 1); // 마지막에 담긴 문자 다시 빼기
                }
            }
        }
    }

}