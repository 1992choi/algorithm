package inflearn;

import java.util.Scanner;

public class Ex009 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static int solution(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]",""));
    }

}