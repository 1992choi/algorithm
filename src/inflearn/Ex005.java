package inflearn;

import java.util.Scanner;

public class Ex005 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
        int lt = 0;
        int rt = str.length() - 1;

        char[] ch = str.toCharArray();
        while (lt < rt) {
            if (Character.isAlphabetic(ch[lt]) && Character.isAlphabetic(ch[rt])) {
                char tmp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = tmp;
            }
            lt++;
            rt--;
        }

        return String.valueOf(ch);
    }

}
