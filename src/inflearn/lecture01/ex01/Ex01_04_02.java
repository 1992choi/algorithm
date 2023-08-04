package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_04_02 {

    public static void main(String[] args) {
        // 입력
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());

        // 풀이
        for (int i = 0; i < num; i++) {
            StringBuffer sb = new StringBuffer(in.nextLine());
            System.out.println(sb.reverse());
        }
    }

}
