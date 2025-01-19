package fastcampus.codingpackage.part1;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/3273
public class Ex009 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        // ai + aj = x를 만족하는 쌍의 수를 구하기
        int answer = 0;

        // 시간초과
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (number[i] + number[j] == x) {
//                    answer++;
//                }
//            }
//        }

        // 정답
        Arrays.sort(number);
        for (int i = 0; i < n; i++) {
            if (number[i] >= x) {
                break;
            }

            for (int j = i + 1; j < n; j++) {
                if (number[i] + number[j] > x) {
                    break;
                } else if (number[i] + number[j] == x) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}
// 풀이
/*

 */