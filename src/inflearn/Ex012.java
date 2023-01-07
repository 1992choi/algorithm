package inflearn;

import java.util.Scanner;

public class Ex012 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String str = in.next();

        System.out.println(solution(num, str));
    }

    public static String solution(int num, String str) {
        String answer = "";
        int blockNum = str.length() / num;
        str = str.replaceAll("#", "1").replaceAll("\\*", "0");

        for (int i = 0; i < num; i++) {
            answer += (char)(Integer.parseInt(str.substring((blockNum * i), (blockNum * (i + 1))), 2));
        }

        return answer;
    }

}