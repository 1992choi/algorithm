package inflearn.lecture01.ex03;

import java.util.Scanner;

public class Ex03_06_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int changeCnt = 0; // 1로 변경한 횟수
        int sum = 0; // 연속 1의 수
        int lt = 0;
        int rt = 0;

        while (rt < n) {
            // k만큼 변경가능하다면 연속부분수열 계속 진행
            if (changeCnt <= k) {
                if (arr[rt] == 0) {
                    changeCnt++;
                }

                rt++;
                sum++;
            }

            // 변경 가능한 카운트가 다 되었다면, 다시 0이 나오는 구간까지 lt이동
            while (changeCnt > k) {
                if (arr[lt] == 0) {
                    changeCnt--;
                }
                sum--;
                lt++;
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

}