package inflearn.lecture01.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ex04_01_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        System.out.println(solution(n, str));
    }

    public static String solution(int n, String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String answer = "";
        int maxCount = 0;

        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            char key = it.next();
            int count = map.get(key);
            if (count > maxCount) {
                maxCount = count;
                answer = String.valueOf(key);
            }
        }

        return answer;
    }

}