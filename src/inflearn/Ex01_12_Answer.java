package inflearn;

import java.util.Scanner;

public class Ex01_12_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String str = in.next();

        System.out.println(solution(num, str));
    }

    public static String solution(int num, String str) {
        String answer = "";
        int blockNum = str.length() / num;
        for (int i = 0; i < num; i++) {
            String tmp = str.substring(0, blockNum).replace('#', '1').replace('*', '0');
            int n = Integer.parseInt(tmp, 2);
            answer += (char)n;

            str = str.substring(blockNum);
        }

        return answer;
    }

}