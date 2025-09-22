package fastcampus.codingpackage.part1.ch04;

import java.util.Scanner;

public class Ex10250 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int h = sc.nextInt(); // 층
            int w = sc.nextInt(); // 호수
            int n = sc.nextInt(); // n번째 손님

            int currentH = 1; // 현재 손님의 층수 (1층부터 시작)
            int currentW = 1; // 현재 손님의 호수 (1호부터 시작)
            int currentN = 1; // 현재 손님의 순서 (1번째부터 시작)

            while (currentN < n) {
                currentH++; // 층 증가
                if (currentH > h) { // 마지막 층이면 호수 증가
                    currentH = 1;
                    currentW++;
                }
                currentN++;
            }

            System.out.printf("%d%02d\n", currentH, currentW);
        }
    }

}

/*
    풀이
    - 손님 한명씩 계산을 해도 풀리는 문제이지만, 시간제한 관점에서 효율적이지는 않는 풀이이다.
      패턴에 의해 순차적으로 배정이 되므로, 아래와 같은 식을 도출할 수 있다.

      > 층 번호 계산: (N-1) % H + 1
      > 호수 번호 계산: (N-1) / H + 1

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();

        int floor = ((N - 1) % H) + 1;  // [1, H]
        int number = (N - 1) / H + 1; // [1, W]
        System.out.printf("%d%02d\n", floor, number);
    }
 */