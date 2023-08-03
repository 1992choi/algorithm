package inflearn.lecture02.ex03;

import java.util.Arrays;

public class Ex03_03 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0}))); // [0, 2, 3, 1, 4, 5, 8, 9]
        System.out.println(Arrays.toString(solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0}))); // [3, 6, 4, 7, 5, 8]
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0}))); // [2, 3, 4, 5, 6, 8, 11, 9, 10, 12]

        // TODO: 2023/05/21. 3번 테스트케이스 실패.
    }

    public static int[] solution(int[] arrival, int[] state) {
        int[] answer = new int[arrival.length];

        int second = 0; // 시간
        boolean[] passFlag = new boolean[arrival.length]; // 현관문을 지나갔는지 판단
        int preState = state[0]; // 이전 사원의 상태(나갔는지 들어왔는지)

        while (!isAllPass(passFlag)) {
            boolean isPass = false;

            for (int i = 0; i < arrival.length; i++) {
                if (passFlag[i]) { // 이미 현관문을 이용한 사람은 제외
                    continue;
                }

                // 현관문 통과 조건 판단
                if (arrival[i] <= second                // CASE 1. 지나갈 순번인지
                        && second >= arrival[i]         // CASE 2. 현재 진행되고 있는 시간 전에 도착했는지 (= 진행시간이 7초인데 8초에 도착한 사람을 통과시킬 수는 없음
                        && preState == state[i]) {      // CASE 3. 이전에 이용한 사람과 같은 방향으로 이용하는지
                    passFlag[i] = true;
                    answer[i] = second;
                    preState = state[i];
                    isPass = true;
                    break;
                }
            }

            /*
                만약 통과한 사람이 없다면 CASE 3.의 조건인 같은 방향이 아니라 조건문을 통과했을 수도 있으니
                해당 조건만 제외하고 다시 판단.
             */
            if (!isPass) {
                for (int i = 0; i < arrival.length; i++) {
                    if (passFlag[i]) { // 이미 현관문을 이용한 사람은 제외
                        continue;
                    }

                    // 현관문 통과 조건 판단
                    if (arrival[i] <= second                // CASE 1. 지나갈 순번인지
                            && second >= arrival[i]) {      // CASE 2. 현재 진행되고 있는 시간 전에 도착했는지 (= 진행시간이 7초인데 8초에 도착한 사람을 통과시킬 수는 없음
                        passFlag[i] = true;
                        answer[i] = second;

                        preState = state[i];
                        break;
                    }
                }
            }

            if (isPass) { // 통과한 사람이 없으면 나가는 사원이 먼저 나가도록 플래그값 다시 셋팅
                preState = 1;
            }

            second++;
        }

        return answer;
    }

    public static boolean isAllPass(boolean[] passFlag) {
        for (boolean isPass : passFlag) {
            if (!isPass) {
                return false;
            }
        }

        return true;
    }

}
