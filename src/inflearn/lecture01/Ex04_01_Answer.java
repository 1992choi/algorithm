package inflearn.lecture01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04_01_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        System.out.println(solution(n, str));
    }

    public static char solution(int n, String str) {
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();

        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

}