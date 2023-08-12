package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_05_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.println(solution(num));
    }

    public static int solution(int num) {
        // 기본 정보 셋팅
        int answer = 0;
        boolean[] isPrime = new boolean[num + 1];
        for (int i = 2; i <= num; i++) { // 0과 1은 소수에서 제외
            isPrime[i] = true;
        }

        // 풀이
        for (int i = 2; i <= num; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= num; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                answer++;
            }
        }

        return answer;
    }

}