package inflearn.lecture02.ex07;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_03 {

    public static void main(String[] args) {
        /*
            TODO: 2023/06/19. 1번 케이스 오답.
                - 만약 2레벨 때, *2를 했을 때 8을 체크해버리면
                      4레벨 때, *2를 했을 때 8은 체크가 되어있기 때문에 뻣어나갈 수가 없음. (답이 이런 케이스일 때의 하위 노드에 있어서 정확한 답을 도출하지 못함)
                  레벨까지 ch배열이 넣기 위하여 배열을 확장시키거나 Set<Integer[]> 형태로 변경해봤지만 1번 케이스는 통과하지만 레벨이 높은 테스트케이스가 실패함.
         */
        System.out.println(solution(1, 11)); // 6
        System.out.println(solution(10, 3)); // 3
        System.out.println(solution(1, 34567)); // 19
        System.out.println(solution(5, 6)); // 2
        System.out.println(solution(2, 54321)); // 20
    }

    public static int solution(int s, int e) {
        int answer = 0;
        int[][] ch = new int[200_001][3];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s); // 현수의 현재 위치
        int cow = e; // 송아지의 현재 위치
        ch[s][0] = 1;
        ch[s][1] = 1;
        ch[s][2] = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            cow += answer;
            for (int i = 0; i < len; i++) {
                int hyunsu = queue.poll(); // 현수의 현재 위치

                // 현수가 움직일 수 있는 수직선상 범위
                if (hyunsu < 0 || hyunsu > 200_000) {
                    continue;
                }

                // 송아지 위치가 200,000을 넘으면 종료
                if (cow > 200_000) {
                    return -1;
                }

                // 현수의 위치와 송아지 위치가 같다면 종료
                if (hyunsu == cow) {
                    return answer;
                }

                // 앞으로 +1 점프
                if (hyunsu < 200_000 && ch[hyunsu + 1][0] == 0) {
                    queue.add(hyunsu + 1);
                    ch[hyunsu + 1][0] = 1;
                }

                // 앞으로 *2 점프
                if (hyunsu <= 100_000 && ch[hyunsu * 2][1] == 0) {
                    queue.add(hyunsu * 2);
                    ch[hyunsu * 2][1] = 1;
                }

                // 뒤로 -1 점프
                if (hyunsu >= 1 && ch[hyunsu - 1][2] == 0) {
                    queue.add(hyunsu - 1);
                    ch[hyunsu - 1][2] = 1;
                }
            }
            answer++;
        }

        return -1;
    }

}