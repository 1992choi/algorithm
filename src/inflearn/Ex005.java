package inflearn;

import java.util.Scanner;

public class Ex005 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    public static String solution(String str) {
        int lt = 0;
        int rt = str.length() - 1;

        char[] ch = str.toCharArray();
        while (lt < rt) {
            if (!Character.isAlphabetic(ch[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(ch[rt])) {
                rt--;
            } else {
                char tmp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(ch);
    }

    public static String solution2(String str) {
        String answer;
        char[] ch = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(ch[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(ch[rt])) {
                rt--;
            } else {
                char tmp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(ch);
        return answer;
    }

}
