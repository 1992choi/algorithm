package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv1. 추억 점수 - https://school.programmers.co.kr/learn/courses/30/lessons/176963
public class Ex176963 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}))); // [19, 15, 6]
        System.out.println(Arrays.toString(solution(new String[]{"kali", "mari", "don"}, new int[]{11, 1, 55}, new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}}))); // [67, 0, 55]
        System.out.println(Arrays.toString(solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}}))); // [5, 15, 0]
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> score = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sumScore = 0;
            for (String s : photo[i]) {
                sumScore += score.getOrDefault(s, 0);
            }
            answer[i] = sumScore;
        }

        return answer;
    }

}
