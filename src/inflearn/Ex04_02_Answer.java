package inflearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04_02_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        System.out.println(solution(a, b));
    }

    public static String solution(String s1, String s2) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();

        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }

}