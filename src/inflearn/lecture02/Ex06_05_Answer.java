package inflearn.lecture02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Ex06_05_Answer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2025505"))); // ["20.25.50.5","20.255.0.5","202.5.50.5","202.55.0.5"]
        System.out.println(Arrays.toString(solution("0000"))); // ["0.0.0.0"]
        System.out.println(Arrays.toString(solution("255003"))); // ["25.50.0.3","255.0.0.3"]
        System.out.println(Arrays.toString(solution("155032012"))); // []
        System.out.println(Arrays.toString(solution("02325123"))); // ["0.23.25.123", "0.23.251.23", "0.232.5.123", "0.232.51.23"]
        System.out.println(Arrays.toString(solution("121431211"))); // ["1.214.31.211", "12.14.31.211", "12.143.1.211", "12.143.12.11", "12.143.121.1", "121.4.31.211", "121.43.1.211", "121.43.12.11", "121.43.121.1"]
    }

    static LinkedList<String> tmp;
    static ArrayList<String> res;

    public static String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, s);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }


    public static void DFS(int start, String s) {
        if (tmp.size() == 4 && start == s.length()) {
            String Ts = "";
            for (String x : tmp) Ts += x + ".";
            res.add(Ts.substring(0, Ts.length() - 1));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start, i + 1);
                if (Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

}