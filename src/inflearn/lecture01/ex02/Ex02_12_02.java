package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_12_02 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        Scanner in = new Scanner(System.in);
        int studentCnt = in.nextInt();
        int testCnt = in.nextInt();
        int[][] arr = new int[testCnt][studentCnt];
        for (int i = 0; i < testCnt; i++) {
            for (int j = 0; j < studentCnt; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(studentCnt, testCnt, arr));
    }

    public static int solution(int studentCnt, int testCnt, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= studentCnt; i++) { // i번째 학생
            for (int j = 1; j <= studentCnt; j++) { // j번째 학생
                int cnt = 0;
                for (int k = 0; k < testCnt; k++) { // 테스트
                    int iScore = 0; // i등수
                    int jScore = 0; // j등수
                    for (int l = 0; l < studentCnt; l++) { // 등수
                        if (arr[k][l] == i) {
                            iScore = l;
                        }
                        if (arr[k][l] == j) {
                            jScore = l;
                        }
                    }
                    if (iScore < jScore) { // 테스트마다 i학생의 등수와 j학생의 등수 비교
                        cnt++;
                    }
                }
                if (cnt == testCnt) { // 테스트 횟수와 i학생이 j학생보다 높은 등수였던 카운트를 비교
                    answer++;
                }
            }
        }

        return answer;
    }

}