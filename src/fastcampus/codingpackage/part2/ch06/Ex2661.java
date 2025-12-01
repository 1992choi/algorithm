package fastcampus.codingpackage.part2.ch06;

import java.util.Scanner;

/*
    풀이
    - 1, 2, 3으로 이루어진 문자열을 길이 n까지 완전탐색으로 생성하는 문제.
    - 단, 어떤 부분 문자열도 바로 앞의 부분 문자열과 동일하게 반복되면 안 된다.
      예) ...1212  → 뒤의 "12"가 앞의 "12"와 동일하므로 금지.
    - 숫자를 하나씩 추가하며, 매 단계에서 ‘나쁜 수열(isBad)’인지 검사하여 가지치기.
    - 첫 번째로 만들어지는 정상적인 수열이 사전순으로 가장 작으므로 정답을 찾으면 즉시 출력하고 탐색 종료.
*/
class Ex2661 {

    public static int n;
    public static int[] numbers = new int[80];

    // 좋은 수열 생성 DFS
    public static boolean solve(int endIndex) {
        // base case: 길이 n 완성
        if (endIndex == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(numbers[i]);
            }
            return true;
        }

        // recursive case: 1,2,3을 하나씩 넣어보며 검사
        for (int i = 1; i <= 3; i++) {
            numbers[endIndex] = i;
            if (!isBad(endIndex)) {      // 나쁜 수열이 아니면 다음 재귀
                if (solve(endIndex + 1)) return true;
            }
        }
        return false;
    }

    /*
        isBad(endIndex)
        - 방금 numbers[endIndex]까지 만들었을 때,
          뒤에서부터 길이 i의 부분 문자열 두 개가 연속으로 동일하면 "나쁜 수열".
          예) ... 2 1 3 2 1 3 → 뒤 "213" == 앞 "213"
        - i는 1부터 가능한 절반 길이까지 확인.
    */
    public static boolean isBad(int endIndex) {
        for (int len = 1; len <= (endIndex + 1) / 2; len++) {
            boolean same = true;
            for (int j = 0; j < len; j++) {
                if (numbers[endIndex - j] != numbers[endIndex - len - j]) {
                    same = false;
                    break;
                }
            }
            if (same) return true;  // 연속된 두 구간이 동일 → 나쁜 수열
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solve(0);
    }

}