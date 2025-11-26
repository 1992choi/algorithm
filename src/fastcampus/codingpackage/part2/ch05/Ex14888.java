package fastcampus.codingpackage.part2.ch05;

import java.util.Scanner;

/*
    풀이

    - 현재 사용 가능한 연산자를 하나 선택해서 다음 숫자와 계산
    - 연산자를 사용했다가 다시 복구(백트래킹)
    - 모든 숫자를 다 사용하면 max/min 갱신
*/
class Ex14888 {

    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MUL = 2;
    public static final int DIV = 3;

    public static int n;
    public static int[] numbers;
    public static int[] operators = new int[4];

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        // 첫 번째 숫자를 시작값으로 DFS 시작
        solve(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int index, int sum) {
        // 모든 숫자 사용 완료 → 최종 값 기록
        if (index == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        // 사용 가능한 연산자를 하나씩 선택
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;  // 연산자 사용

                switch (i) {
                    case PLUS -> solve(index + 1, sum + numbers[index]);
                    case MINUS -> solve(index + 1, sum - numbers[index]);
                    case MUL -> solve(index + 1, sum * numbers[index]);
                    case DIV -> solve(index + 1, sum / numbers[index]); // 문제 규칙: 음수 나눗셈은 0 방향 버림
                }

                operators[i]++;  // 연산자 복구(백트래킹)
            }
        }
    }

}
