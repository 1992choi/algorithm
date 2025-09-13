package fastcampus.codingpackage.part1.ch04;

import java.util.Scanner;

public class Ex11005 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(Long.toString(n, b).toUpperCase());
    }

}