package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_03_02 {

    public static void main(String[] args) {
        // 입력
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        // 풀이
        String maxStr = "";
        String[] strs = str.split(" ");

        for (String currentStr : strs) {
            if (maxStr.length() < currentStr.length()) {
                maxStr = currentStr;
            }
        }

        System.out.println(maxStr);
    }

}
