package fastcampus.codingpackage.part1;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1919
public class Ex002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.next();
        String strB = scanner.next();

        char[] ch1 = new char[26];
        char[] ch2 = new char[26];

        for (char ch : strA.toCharArray()) {
            ch1[ch - 'a']++;
        }
        for (char ch : strB.toCharArray()) {
            ch2[ch - 'a']++;
        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (ch1[i] != ch2[i]) {
                answer += Math.abs(ch1[i] - ch2[i]);
            }
        }
        System.out.println(answer);
    }

}

// 풀이
/*
class Main {
    public static int[] getAlphabetCountArray(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'a']++;
        return count;
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] countA = getAlphabetCountArray(a);
        int[] countB = getAlphabetCountArray(b);

        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += Math.abs(countA[i] - countB[i]);
        System.out.println(ans);
    }
*/