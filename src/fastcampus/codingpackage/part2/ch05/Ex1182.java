package fastcampus.codingpackage.part2.ch05;

import java.util.Scanner;

class Ex1182 {

    public static int[] numbers;
    public static int s;
    public static int answer = 0;

    public static void solve(int index, int sum) {
        // 모든 판단이 끝난 경우 종료
        if (index == numbers.length) {
            return;
        }

        // 조건을 만족하는 경우 부분수열의 개수 누적.
        // numbers[index] -> 해당 항목을 고른경우만 누적하는 이유
        // -  numbers[index]를 선택하지 않은 경우는 이전 재귀에서의 합과 동을힌 값이므로 선택한 경우만 판단해서 answer를 증가시키면 된다.
        if (sum + numbers[index] == s) {
            answer++;
        }

        solve(index + 1, sum); // numbers[index]을 선택하지 않는 경우
        solve(index + 1, sum + numbers[index]); // numbers[index]을 선택하는 경우
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        solve(0, 0);
        System.out.println(answer);
    }

}
