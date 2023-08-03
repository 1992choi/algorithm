package inflearn.lecture01.ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04_04_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();

        System.out.println(solution(a, b));
    }

    public static int solution(String a, String b) {
        int answer = 0;
        Map<Character, Integer> am = new HashMap<>();
        Map<Character, Integer> bm = new HashMap<>();
        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int l = b.length() - 1;
        for (int i = 0; i < l; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = l; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if (am.equals(bm)) {
                answer++;
            }

            am.put(a.charAt(lt), am.getOrDefault(a.charAt(lt), 0) - 1);
            if (am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }
            lt++;
        }

        return answer;
    }

}
