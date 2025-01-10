package fastcampus.codingpackage.part1;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1157
public class Ex003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        str = str.toLowerCase();

        int[] alphabetCount = new int[26];

        for (char ch : str.toCharArray()) {
            alphabetCount[ch - 'a']++;
        }

        int maxCount = Arrays.stream(alphabetCount).max().getAsInt();
        int foundCount = 0;
        String answer = "?";

        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] == maxCount) {
                foundCount++;
                answer = String.valueOf(Character.toUpperCase((char) (i + 'a')));
            }

            if (foundCount > 1) {
                answer = "?";
                break;
            }
        }

        System.out.println(answer);
    }

}

// 풀이
/*
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'A']++;

        int maxCount = 0;
        char maxAlphabet = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlphabet = (char)('A' + i);
            } else if (count[i] == maxCount) {
                maxAlphabet = '?';
            }
        }
        System.out.println(maxAlphabet);
    }
}
*/