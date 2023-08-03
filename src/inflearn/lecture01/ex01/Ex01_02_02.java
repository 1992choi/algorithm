package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_02_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        StringBuffer sb = new StringBuffer();
        for (char ch : str.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }

        System.out.println(sb);
    }

}
