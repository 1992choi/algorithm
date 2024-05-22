package programmers.lv2;

// 프로그래머스 Lv2. 멀리 뛰기 - https://school.programmers.co.kr/learn/courses/30/lessons/12914
// 부분통과 - 특정 케이스부터 시간 초과 발생
public class Ex12914 {

    public static void main(String[] args) {
        System.out.println(solution(4)); // 5
        System.out.println(solution(3)); // 3
    }

    static long answer = 0;

    public static long solution(int n) {
        answer = 0;
        dfs(0, n);
        return answer % 1234567;
    }

    public static void dfs(int current, int n) {
        if (current > n) {
            return;
        }

        if (current == n) {
            answer++;
        } else {
            // 1칸 뛰기
            dfs(current + 1, n);

            // 2칸 뛰기
            dfs(current + 2, n);
        }
    }

}