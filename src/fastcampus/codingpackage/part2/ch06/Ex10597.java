package fastcampus.codingpackage.part2.ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    풀이
    - 입력은 1~n까지의 정수를 공백 없이 이어붙인 문자열이다.
      → 예: n=20 → "1234567891011121314151617181920"
    - 문자열을 다시 1~n의 숫자들로 복원하는 문제.
    - 규칙:
        - 1~9는 한 자리 숫자
        - 10 이상은 두 자리 숫자
    - n은 주어진 문자열 길이로부터 유추한다.
        - 첫 9개 숫자는 1자리씩 → 길이 9
        - 그 이후는 두 자리씩 → (len-9)/2 개
    - DFS로 index에서 시작하여 1자리 혹은 2자리 숫자를 선택하며
      사용되지 않은 숫자인지(check 배열) 확인하고 진입한다.
    - 문자열 끝까지 도달하면 정답이므로 즉시 출력 후 프로그램 종료(System.exit).
*/
class Ex10597 {

    static int[] check = new int[101]; // 숫자 사용 여부 체크
    static char[] input;
    static int n = 0;                  // 최종 숫자 범위 (1 ~ n)
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.next().toCharArray();

        // n 계산
        // 길이가 9 이하이면 그대로 n = length
        // 길이가 10 이상이면: 1~9는 한 자리이므로 9,
        // 이후는 모두 두 자리이므로 (len - 9) / 2
        n = input.length > 9 ? 9 + (input.length - 9) / 2 : input.length;

        solve(0);
    }

    static void solve(int index) {
        // base case: 문자열 끝에 도달하면 정답
        if (index >= input.length) {
            for (Integer num : answer) {
                System.out.print(num + " ");
            }
            System.exit(0); // 첫 번째 정답만 출력하면 끝
        }

        // 1자리 숫자
        int target1 = atoi(input, index, 1);
        if (target1 <= n && check[target1] == 0) {
            check[target1] = 1;
            answer.add(target1);
            solve(index + 1);
            answer.remove(answer.size() - 1);
            check[target1] = 0;
        }

        // 2자리 숫자를 만들 수 없으면 종료
        if (index + 1 >= input.length) return;

        // 2자리 숫자
        int target2 = atoi(input, index, 2);
        if (target2 <= n && check[target2] == 0) {
            check[target2] = 1;
            answer.add(target2);
            solve(index + 2);
            answer.remove(answer.size() - 1);
            check[target2] = 0;
        }
    }

    // char 배열에서 숫자 substring을 정수로 변환
    static int atoi(char[] input, int start, int length) {
        int result = 0;
        for (int i = start; i < start + length; i++) {
            result = result * 10 + (input[i] - '0');
        }
        return result;
    }

}
