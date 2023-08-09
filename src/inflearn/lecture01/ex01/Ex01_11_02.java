package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_11_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
        str += "0"; // 마지막 문자까지 탐색하기 위하여 의미없는 문자 1개를 추가
        String answer = "";
        int dupCount = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                dupCount++;
            } else {
                answer += String.valueOf(str.charAt(i - 1));
                if (dupCount != 1) {
                    answer += dupCount;
                }
                dupCount = 1;
            }
        }

        return answer;
    }

}
