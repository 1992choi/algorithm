package inflearn.lecture01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04_02 {

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

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            map1.put(char1[i], map1.getOrDefault(char1[i], 0) + 1);
            map2.put(char2[i], map2.getOrDefault(char2[i], 0) + 1);
        }

        for (int i = 0; i < str1.length(); i++) {
            char key = char1[i];
            if (map1.get(key) != map2.get(key)) {
                return "NO";
            }
        }

        return "YES";
    }

}