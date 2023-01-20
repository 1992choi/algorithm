package inflearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();

        System.out.println(solution(s, t));
    }

    public static int solution(String s, String t) {
        int answer = 0;
        int blockSize = t.length();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        // init
        for (int i = 0; i < blockSize; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (tMap.equals(sMap)) {
            answer++;
        }

        // loop
        for (int i = blockSize; i < s.length(); i++) {
            char leftValue = s.charAt(i - blockSize);
            sMap.put(leftValue, sMap.getOrDefault(leftValue, 0) - 1);
            if (sMap.get(leftValue) == 0) {
                sMap.remove(leftValue);
            }

            char rightValue = s.charAt(i);
            sMap.put(rightValue, sMap.getOrDefault(rightValue, 0) + 1);

            if (tMap.equals(sMap)) {
                answer++;
            }
        }

        return answer;
    }

}
