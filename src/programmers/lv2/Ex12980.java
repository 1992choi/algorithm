package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 Lv2. 점프와 순간 이동 - https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class Ex12980 {

    static int answer = 0;
    static int[] memoization;

    public static void main(String[] args) {
        System.out.println(solution(5)); // 2
        System.out.println(solution(6)); // 2
        System.out.println(solution(5000)); // 5
    }

    // 정확성 테스트 모두 통과 && 효율성 통과 못함
    public static int solution(int n) {
        memoization = new int[n + 1];
        Arrays.fill(memoization, Integer.MAX_VALUE);
        answer = Integer.MAX_VALUE;

        // 처음은 무조건 점프
        int location = 1;
        int cost = 1;

        // 2번째 이후 움직임
        dfs(location, n, cost);

        return answer;
    }

    public static void dfs(int location, int n, int cost) {
        if (location > n || cost > answer) {
            return;
        }
        if (location == n) {
            answer = cost;
        } else {
            // 순간이동 (현재에서 x2로 점프)
            if (location <= n / 2) {
                if (memoization[location * 2] < cost) {
                    return;
                }
                memoization[location * 2] = cost;
                dfs(location * 2, n, cost);
            }

            // 점프 (1칸 앞으로 점프)
            if (location <= n - 1) {
                if (memoization[location + 1] < cost + 1) {
                    return;
                }
                memoization[location + 1] = cost + 1;
                dfs(location + 1, n, cost + 1);
            }
        }
    }

}
