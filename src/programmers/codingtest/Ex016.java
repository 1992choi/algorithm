
package programmers.codingtest;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class Ex016 {

    public static void main(String[] args) {
        System.out.println((solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println((solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Work> works = new ArrayDeque<>();

        // 각 작업을 순서(seq)와 현재 진행률(progress)로 큐에 적재
        for (int i = 0; i < progresses.length; i++) {
            works.add(new Work(i, progresses[i]));
        }

        // 남은 작업이 없어질 때까지 "하루" 단위로 시뮬레이션 반복
        while (!works.isEmpty()) {
            // 1. 작업 진행: 큐에 남아있는 모든 작업의 진행률을 speed만큼 증가
            for (int i = 0; i < works.size(); i++) {
                Work currentWork = works.poll();
                currentWork.progress += speeds[currentWork.seq];
                works.add(currentWork);
            }

            // 2. 작업 판단: 맨 앞(가장 먼저 배포돼야 할 작업)부터 순서대로 완료 여부 확인
            //    - 완료된 작업은 배포 그룹에 포함시키고 큐에서 제거
            //    - 아직 완료되지 않은 작업을 만나면 그 뒤는 더 볼 필요 없이 큐에 그대로 남김
            int doneCount = 0;
            int workSize = works.size();
            // minSeq: 현재 배포 대기열에서 "가장 먼저 배포되어야 할 작업"의 순서(seq)
            // 배포는 seq 순서대로만 이루어지므로, 중간에 완료된 작업이 있어도
            // 자기 앞 순서(minSeq)가 먼저 완료돼서 큐에서 빠지기 전까지는 배포될 수 없음
            int minSeq = works.peek().seq;

            for (int i = 0; i < workSize; i++) {
                Work currentWork = works.poll();
                // progress >= 100: 작업 자체는 완료됨
                // minSeq == currentWork.seq: 그 작업이 현재 "배포 차례"인 작업과 일치함
                // 두 조건을 모두 만족해야 실제로 배포(doneCount++)되고,
                // 다음 배포 차례(minSeq)가 한 칸 뒤로 넘어감
                if (currentWork.progress >= 100 && minSeq == currentWork.seq) {
                    doneCount++;
                    minSeq++;
                } else {
                    works.add(currentWork);
                }
            }

            // 3. 이번 "하루"에 배포된 작업이 있으면 배포 개수를 결과에 기록
            if (doneCount != 0) {
                answer.add(doneCount);
            }
        }

        return answer;
    }

}

class Work {
    int seq;
    int progress;

    public Work(int seq, int progress) {
        this.seq = seq;
        this.progress = progress;
    }
}