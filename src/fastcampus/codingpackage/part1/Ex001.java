package fastcampus.codingpackage.part1;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2744
public class Ex001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                System.out.print(Character.toLowerCase(str.charAt(i)));
            } else {
                System.out.print(Character.toUpperCase(str.charAt(i)));
            }
        }
    }

}

// 풀이
/*
class Main  {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] ans = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if ('a' <= ans[i] && ans[i] <= 'z')
                ans[i] = (char)('A' + ans[i] - 'a');
            else ans[i] = (char)('a' + ans[i] - 'A');
        }
        System.out.println(ans);
    }
}
*/