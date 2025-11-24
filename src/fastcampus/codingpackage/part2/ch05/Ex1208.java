package fastcampus.codingpackage.part2.ch05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    풀이
    - 부분수열의 합은 배열을 절반으로 나눈 뒤에도 모든 경우의 수를 그대로 유지할 수 있다.
      (부분수열은 '어떤 원소를 선택했는가'만 중요하고, 왼쪽·오른쪽을 독립적으로 선택해도 전체 조합이 완전히 표현되기 때문)
    - 따라서 배열을 두 구간(Left, Right)으로 나누어 각 구간의 부분합을 계산한다.
    - Left에서 가능한 모든 부분합의 출현 횟수를 Map에 저장한다.
    - Right에서 부분합을 계산하면서, S - (Right 부분합)이 Left에 몇 번 존재하는지 조회한다.
    - 두 구간의 조합으로 전체 부분수열의 합을 완성하는 Meet-in-the-Middle 방식으로 전체 경우의 수를 효율적으로 계산한다.
*/
class Ex1208 {

    static int s;
    static int[] numbers;
    static long answer = 0;
    public static int status = -1;
    static final int LEFT = 0;
    static final int RIGHT = 1;

    static Map<Integer, Integer> cnt = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        status = LEFT;
        solve(0, n / 2, 0);      // 왼쪽 부분합 저장

        status = RIGHT;
        solve(n / 2, n, 0);      // 오른쪽 부분합과 매칭하며 정답 계산

        if (s == 0) answer--;    // 공집합 제거
        System.out.println(answer);
    }

    public static void solve(int index, int end, int sum) {
        // 끝까지 도달한 경우 현재 부분합 처리
        if (index == end) {
            if (status == LEFT) {
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            } else { // RIGHT
                answer += cnt.getOrDefault(s - sum, 0);
            }
            return;
        }

        // 현재 요소를 선택하지 않는 경우
        solve(index + 1, end, sum);

        // 현재 요소를 선택하는 경우
        solve(index + 1, end, sum + numbers[index]);
    }

}