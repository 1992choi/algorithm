package inflearn.lecture01;

import java.util.Scanner;

public class Ex02_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.println(solution(num));
    }

    public static int solution(int num) {
        int answer = 0;

        for (int i = 1; i <= num; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            if (count == 2) {
                answer++;
            }
        }

        return answer;
    }

}