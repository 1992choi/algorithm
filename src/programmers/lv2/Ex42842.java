package programmers.lv2;

// 프로그래머스 Lv2. 점프와 순간 이동 - https://school.programmers.co.kr/learn/courses/30/lessons/12980
// 부분통과 - 효율성 테스트 실패
public class Ex42842 {

    public static void main(String[] args) {
        System.out.println(solution(5)); // 2
        System.out.println(solution(6)); // 2
        System.out.println(solution(5000)); // 5
    }

    static long answer;

    public static long solution(long n) {
        answer = Long.MAX_VALUE;

        // 처음은 무조건 점프
        long location = 1;
        long cost = 1;

        // 2번째 이후 움직임
        dfs(location, n, cost);

        return answer;
    }

    public static void dfs(long location, long n, long cost) {
        if (location > n || cost > answer) {
            return;
        }

        if (location == n) {
            answer = cost;
        } else {
            // 순간이동 (현재에서 x2로 점프)
            dfs(location * 2, n, cost);

            // 점프 (1칸 앞으로 점프)
            dfs(location + 1, n, cost + 1);
        }
    }

}

