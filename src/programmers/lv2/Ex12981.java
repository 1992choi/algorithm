package programmers.lv2;

import java.util.*;

// 프로그래머스 Lv2. 영어 끝말잇기 - https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class Ex12981 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}))); // [3, 3]
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))); // [0, 0]
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}))); // [1, 3]
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "kick"}))); // [1, 2]
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> list = new ArrayList<>(); // 사용할 단어를 넣을 리스트
        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i]) ||
                    (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) ||
                    words[i].length() == 1
            ) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else {
                list.add(words[i]);
            }
        }

        return answer;
    }

}
