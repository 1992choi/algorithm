package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_05_02 {

    public static void main(String[] args) {
        // 입력
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chars = str.toCharArray();

        // 풀이
        int lp = 0;
        int rp = str.length() - 1;

        while (lp < rp) {
            if (Character.isAlphabetic(str.charAt(lp)) && Character.isAlphabetic(str.charAt(rp))) {
                char tmp = chars[lp];
                chars[lp] = chars[rp];
                chars[rp] = tmp;
                lp++;
                rp--;
            } else if (Character.isAlphabetic(str.charAt(lp))) {
                rp--;
            } else if (Character.isAlphabetic(str.charAt(rp))) {
                lp++;
            } else {
                lp++;
                rp--;
            }
        }

        for (char c : chars) {
            System.out.print(c);
        }
    }

}
