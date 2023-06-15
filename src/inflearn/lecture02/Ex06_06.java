package inflearn.lecture02;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex06_06 {

    public static void main(String[] args) {
        System.out.println(solution("25114")); // 6
        System.out.println(solution("23251232")); // 12
        System.out.println(solution("21020132")); // 2
        System.out.println(solution("21350")); // 0
        System.out.println(solution("120225")); // 3
        System.out.println(solution("232012521")); // 12
    }

    static int answer;
    static LinkedList<String> tmp;
    static ArrayList<String> res;

    public static int solution(String s) {
        answer = 0;
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, s);

        return answer;
    }


    public static void DFS(int start, String s) {
        if (start == s.length()) {
            answer++;
        } else {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(start) == '0' && i > start) {
                    return;
                }
                String num = s.substring(start, i + 1);
                if (Integer.parseInt(num) < 1 || Integer.parseInt(num) > 26) {
                    return;
                }
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

}