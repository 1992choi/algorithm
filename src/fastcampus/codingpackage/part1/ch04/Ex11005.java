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

/*
    풀이

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int B = sc.nextInt();

    String ans = "";
    while (N > 0) {
        int digit = N % B;
        if (digit < 10) ans += digit;
        else ans += (char)('A' + digit - 10);
        N /= B;
    }

    System.out.println(new StringBuilder(ans).reverse());
 */