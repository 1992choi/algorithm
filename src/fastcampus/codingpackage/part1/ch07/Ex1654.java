package fastcampus.codingpackage.part1.ch07;

import java.util.Scanner;

public class Ex1654 {

    public static void main(String[] args) {
        // 시간초과
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[k];

        int sum = 0; // 가지고 있는 랜선의 총 개수
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int answer = 0;
        int cutLength = sum / n; // 자를 랜선의 길이 (가지고 있는 랜선의 총 길이를 필요한 갯수로 나누기 : 각각의 랜선이 얼마의 길이만큼씩 필요한지 파악하기 위함.)

        while (cutLength > 0) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                count += arr[i] / cutLength; // 각 랜선을 기준이 되는 랜선 길이로 잘랐을 때의 갯수 누적
            }

            if (count >= n) { // 기준 갯수를 만족하면 정답에 누적
                answer = Math.max(answer, cutLength);
            }

            cutLength--;
        }

        System.out.println(answer);
    }

}
