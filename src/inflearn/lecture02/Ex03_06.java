package inflearn.lecture02;

import java.util.*;

public class Ex03_06 {

    public static void main(String[] args) {
        System.out.println(solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}})); // 0
        System.out.println(solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}})); // 0
        System.out.println(solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}})); // 1
        System.out.println(solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}})); // 2
    }

    public static int solution(int n, int[][] meetings) {
        int answer = 0;
        int time = 0;
        int meetingsIdx = 0;

        // 시작 시간이 빠른 순으로 정렬
        Arrays.sort(meetings, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        //System.out.println(Arrays.deepToString(meetings));

        // 데이터 처리할 변수 선언
        List<Queue<Integer>> queueList = new ArrayList<>(); // n개의 회의실에 대한 종료시간을 담을 큐
        int[] finishTime = new int[n]; // 회의가 끝나는 시간
        int[] useCount = new int[n]; // 회의실이 사용된 횟수
        for (int i = 0; i < n; i++) { // 큐 리스트 초기화
            queueList.add(new LinkedList<>());
        }

        // 첫 데이터 처리 (가장 빠른 시간의 회의는 0번째 회의실로 배정)
        queueList.get(0).add(meetings[0][1]);
        useCount[0]++;
        meetingsIdx++;

        // 시작 시간을 첫 회의가 시작하는 시점으로 설정
        time = meetings[0][0];

        while (time < 50) {
            //System.out.println("time=" + time);
            //System.out.println("meetingsIdx=" + meetingsIdx);
            if (meetingsIdx == meetings.length) {
                break;
            }


            // 사용 시간이 넘은 회의실 종료
            for (int i = 0; i < n; i++) {
                Queue<Integer> queue = queueList.get(i);
                // System.out.println(i + "번째 회의실 종료 판단, queue.isEmpty() = " + queue.isEmpty());
                if (!queue.isEmpty() && queue.peek() == time) {
                    finishTime[i] += queue.poll();
                    //System.out.println(i + "번째 회의실 종료. finishTime = " + finishTime[i]);
                } else {
                    //System.out.println(i + "번째 회의실 진행 중 또는 비어있음");
                }

            }

            // 이용 가능한 회의실 찾기
            //System.out.println("현재시간=" + time + ", 회의 시작시간=" + meetings[meetingsIdx][0]);
            if (meetings[meetingsIdx][0] <= time) {
                for (int i = 0; i < n; i++) {
                    Queue<Integer> queue = queueList.get(i);

                    if (!queue.isEmpty()) { // 회의실이 이미 사용중이라면 다음 회의실 판단
                        continue;
                    }

                    // 비어있는 회의실에 넣기. 단 이전 종료시간 + 진행될 회의실의 종료시간으로 종료시간을 설정한다.
                    //System.out.println(meetingsIdx + "번째 회의 ===> " + i + " 번 회의실로 배정!!!");
                    if (finishTime[i] > meetings[meetingsIdx][0]) { // 종료시간이 시작시간보다 크면 지연되는 것이므로 아래와 같이 계산
                        queue.add(finishTime[i] + meetings[meetingsIdx][1] - meetings[meetingsIdx][0]);
                    } else { // 그렇지 않다면 원래 예정대로 진행되는 것이니 종료시간을 아래와 같이 계산
                        queue.add(meetings[meetingsIdx][1]);
                    }
                    useCount[i]++;
                    meetingsIdx++;
                    //System.out.println(i + " 번 회의실 사용횟수 : " + useCount[i]);
                    break; // 회의실 배정되면 [이용 가능한 회의실 찾기] 종료
                }
            }

            time++;
            //System.out.println("\n\n\n");
        }

        // 가장 많이 사용된 회의실 찾기
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < useCount.length; i++) {
            if (useCount[i] > maxCount) {
                maxCount = useCount[i];
                answer = i;
            }
        }

        return answer;
    }

}