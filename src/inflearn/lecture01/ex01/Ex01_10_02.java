package inflearn.lecture01.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_10_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";
        String s = str.split(" ")[0];
        char t = str.split(" ")[1].charAt(0);

        // 문자열에서 문자 t와 동일한 문자의 인덱스 찾기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                list.add(i);
            }
        }

        // 최소거리 구하기
        for (int i = 0; i < s.length(); i++) {
            int minValue = str.length();
            for (int j = 0; j < list.size(); j++) {
                minValue = Math.min(minValue, Math.abs(i - list.get(j)));
            }
            answer += minValue + " ";
        }

        return answer;
    }

}
