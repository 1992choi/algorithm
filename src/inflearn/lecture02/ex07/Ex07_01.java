package inflearn.lecture02.ex07;

public class Ex07_01 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 1, 2, 1, 1})); // 3
        System.out.println(solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1})); // -1
        System.out.println(solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1})); // 7
        System.out.println(solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1})); // 6

        // TODO: 2023/06/16. 아래 케이스 틀림 :  index가 1일 때, 선택할 수 있는 범위는 2, 1, 1인데 아래의 로직대로면 가장 큰수를 선택하기 때문에 2가 선택되어 마지막 1을 선택하는 케이스보다 안좋은 케이스를 선택하게 되어 오답이 나옴.
        System.out.println(solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1})); // 8
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int currentIdx = 0; // 현위치

        while (currentIdx <= 100) {
            int jumpRange = nums[currentIdx]; // 점프로 갈 수 있는 범위
            int maxRange = Integer.MIN_VALUE; // 점프로 갈 수 있는 범위 중 크기가 가장 큰 값
            int maxRangeIdx = 0; // 점프로 갈 수 있는 범위 중 크기가 가장 큰 값의 인덱스
            int lastIdx = currentIdx + jumpRange; // 점프로 갈 수 있는 곳 중 마지막 인덱스.

            // 점프로 갈 수 있는 범위가 배열 범위를 넘어 갔으면, 마지막 점프로 도착을 할 수 있으므로 answer+1로 종료시킴
            if (lastIdx >= nums.length - 1) {
                return answer + 1;
            }

            // 현재위치 + 1 ~ 점프로 갈 수 있는 범위 중 큰수와 인덱스 찾기
            for (int i = currentIdx + 1; i <= lastIdx; i++) {
                if (nums[i] >= maxRange) {
                    maxRange = nums[i];
                    maxRangeIdx = i;
                }
            }

            // 만약 가장 큰 수가 0이면 다음이동을 하지 못하므로 -1 리턴
            if (maxRange == 0) {
                return -1;
            }

            if (currentIdx >= nums.length - 1) {
                break;
            }

            // 다음 점프로 가장 많이갈 수 있는 구간으로 점프하기
            currentIdx = maxRangeIdx;
            answer++;
        }

        return answer;
    }

}