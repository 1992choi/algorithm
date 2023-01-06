package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex010 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputValue = in.nextLine();
        String str = inputValue.split(" ")[0];
        char targetChar = inputValue.split(" ")[1].charAt(0);

        System.out.println(solution(str, targetChar));
        System.out.println(solution2(str, targetChar));
    }

    public static String solution(String str, char targetChar) {
        char[] chars = str.toCharArray();
        List<Integer> targetList = new ArrayList<>(); // 타겟 문자가 들어있는 인덱스 추출
        String answer = "";

        for (int i = 0 ; i < chars.length; i++) {
            if (chars[i] == targetChar) {
                targetList.add(i);
            }
        }

        for (int i = 0 ; i < chars.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < targetList.size(); j++) {
                int tmpNum = Math.abs(i - targetList.get(j));
                if (min > tmpNum) {
                    min = tmpNum;
                }
            }
            answer += min + " ";
        }

        return answer.substring(0, answer.length() - 1);
    }

    public static String solution2(String str, char targetChar) {
        char[] chars = str.toCharArray();
        int[] answer = new int[str.length()];

        int p = 100;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == targetChar) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 100;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == targetChar) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return Arrays.toString(answer);
    }

}