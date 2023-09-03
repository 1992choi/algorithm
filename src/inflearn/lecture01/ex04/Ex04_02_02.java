package inflearn.lecture01.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ex04_02_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        System.out.println(solution(str1, str2));
    }

    public static String solution(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return "NO";
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }

        Iterator<Character> it = map1.keySet().iterator();
        while (it.hasNext()) {
            char key = it.next();
            if (map1.get(key) != map2.get(key)) {
                return "NO";
            }
        }

        return "YES";
    }

}