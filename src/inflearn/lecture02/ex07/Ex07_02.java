package inflearn.lecture02.ex07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex07_02 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{11, 7, 20}, 3, 2, 10)); // 5
        System.out.println(solution(new int[]{1, 15, 11}, 3, 2, 5)); // 5
        System.out.println(solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25)); // 14
        System.out.println(solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18)); // -1
        System.out.println(solution(new int[]{10, 15, 20}, 3, 2, 2)); // 4
    }

    public static int solution(int[] pool, int a, int b, int home) {
        int answer = 0;

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{a, 1}); // 최초 a만큼 전진
        answer++;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer[] action = queue.poll();
                int x = action[0]; // 현재 위치
                int jump = action[1]; // 점프 위치(0=뒤로 점프, 1=앞으로 점프)

                // 현재 위치가 웅덩이라면 skip, 수직선의 좌표를 벗아나면 skip
                if (Arrays.stream(pool).anyMatch(p -> p == x) || x < 0 || x > 10_000) {
                    continue;
                }

                // 현재 위치가 집이면 종료
                if (x == home) {
                    return answer;
                }

                // 앞으로 점프
                queue.add(new Integer[]{x + a, 1});

                // 뒤로 점프 (이전 점프가 앞으로 점프였을 때만 뒤로 점프 가능)
                if (jump == 1) {
                    queue.add(new Integer[]{x - b, 0});
                }
            }
            answer++;
        }

        return -1;
    }

}