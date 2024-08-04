package programmers.lv2;

// 프로그래머스 Lv2. 피로도 - https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Ex87946 {

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}})); // 3
    }

    public static int answer;
    public static boolean[] visit;
    public static int num[];

    public static int solution(int k, int[][] dungeons) {
        answer = 0;

        for (int i = 0; i < dungeons.length; i++) {
            visit = new boolean[dungeons.length];
            num = new int[dungeons.length];

            visit[i] = true;
            num[0] = i;
            dfs(0, k, dungeons); // 완전 탐색
            visit[i] = false;
        }

        return answer;
    }

    public static void dfs(int level, int k, int[][] dungeons) {
        if (level == dungeons.length - 1) {
            // 모든 던전 방문했을 경우, 몇 개의 던전을 클리어할 수 있는지 확인
            int clearCount = 0;
            for (int i = 0; i < num.length; i++) {
                if (k >= dungeons[num[i]][0]) {
                    clearCount++;
                    k -= dungeons[num[i]][1];
                }
            }

            answer = Math.max(answer, clearCount);
        } else {
            for (int i = 0; i < dungeons.length; i++) {
                if (!visit[i]) {
                    visit[i] = true; // 방문한 던전 체크
                    num[level + 1] = i; // 방문한 던전 번호 기억하기
                    dfs(level + 1, k, dungeons);
                    visit[i] = false;
                }
            }
        }
    }

}

