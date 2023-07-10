package inflearn.lecture02;

import java.util.Scanner;

public class Ex09_06 {

    public static void main(String[] args) {
        /**
         DP없이 풀어본 문제.
         테스트케이스는 맞았으나 실제 백준 사이트에서는 오답
         */
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 벼의 수
//        int[] arr = new int[n]; // 벼의 가치
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        int answer = 0;
//        int round = 1;
//        int lp = 0;
//        int rp = n - 1;
//
//        while (lp <= rp) {
//            if (arr[lp] > arr[rp]) {
//                answer += arr[rp--] * round;
//            } else {
//                answer += arr[lp++] * round;
//            }
//            round++;
//        }
//
//        System.out.println(answer);


        /**
         문제해법보고 푼 코드
         5 1 3 1 5 2
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 벼의 수
        int[] arr = new int[n + 1]; // 벼의 가치
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // i번째 벼부터 j번째 벼까지 수확했을 때 얻을 수 있는 최대이익
        int[][] dy = new int[n + 1][n + 1];

        /*
            - 1개인 케이스 : 1, 2, 3, 4, 5
            - 2개인 케이스 : 1~2, 2~3, 3~4, 4~5
            - 3개인 케이스 : 1~3, 2~4, 3~5
            - 4개인 케이스 : 1~4, 2~5
            - 5개인 케이스 : 1~5 (= 전체에 대한 답)
         */
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                //System.out.println(j + "~" + (j + i));
                /*
                    만약 부분수열이 3,1,5,2라면 아래의 케이스로 생각할 수 있다.
                    1) 3과 1,5,2로 나뉜 케이스
                        - [1,5,2]의 다이나믹 값에 3+1+5+2를 더해주면
                          3,1,5,2의 다이나믹 값을 구할 수 있다.
                          * 3+1+5+2를 더해주는 이유 : [1, 5, 2]는 1*1, 2*2, 5*3으로 수확을 했다고 가정할 때,
                                                  3이 추가된 후 3부터 수확하면 [1, 5, 2]는 '1*1, 2*2, 5*3'에서 '1*2, 2*3, 5*4'로 변경되게 된다.
                                                  결론적으로 [1, 5, 2]의 다이나믹 값에 3+1+5+2를 더해주면 [3,1,5,2]의 다이나믹 값이 된다.
                    2) 3,1,5와 2로 나뉜 케이스
                        - 1)의 설명과 동일하다.
                 */

                if (j != (j + i)) { // 1개인 케이스에서 마지막 행과 열인 5행 5열(=2차원 배열의 우측하단)을 넘어가지 않기 위해 조건 추가
                    // 3,1,5,2 계산일 때, [1,5,2]의 다이나믹 값과 [3,1,5]의 다이나믹 값 중 큰 값 찾기
                    dy[j][j + i] += Math.max(dy[j][j + i - 1], dy[j + 1][j + i]);
                }

                // 다이나믹을 구한 후 '3+1+5+2'를 다시 더해주는 경우. 미리 구간합을 구하면 좋으나 풀이의 이해를 위해 구간합없이 구현
                for (int k = j; k <= j + i; k++) {
                    dy[j][j + i] += arr[k];
                }

                //printDy(dy);
            }
        }

        System.out.println(dy[1][n]);
    }

    static void printDy(int[][] dy) {
        for (int[] i : dy) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("------");
    }

}