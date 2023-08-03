package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_01_2 {

    public static void main(String[] args) {
        int answer = 0;

        // 입력
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        char ch = in.nextLine().toLowerCase().charAt(0);

        // 개수 구하기
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == ch) {
                answer++;
            }
        }

        // 정답 출력
        System.out.println(answer);
    }

}
