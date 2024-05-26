package programmers.lv2;

import java.util.*;
import java.util.stream.IntStream;

// 프로그래머스 Lv2. 기능개발 - https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class Ex42586 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution2(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); // [2, 1]
        System.out.println(Arrays.toString(solution2(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))); // [1, 3, 2]
    }

    // 테스트케이스 일부 오답.
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];

        // 작업이 완료되는 일자 구하기
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];// 남은 작업양
            if (remain % speeds[i] == 0) {
                days[i] = remain / speeds[i];
            } else {
                days[i] = remain / speeds[i] + 1;
            }
        }

        // 배포 판단
        int releaseGroupCnt = 1;
        for (int i = 1; i < days.length; i++) {
            if (days[i - 1] >= days[i]) { // 이전 작업보다 배포일이 작다면, 앞에꺼와 함께 배포할 수 있음
                releaseGroupCnt++;
            } else {
                answer.add(releaseGroupCnt);
                releaseGroupCnt = 1;
            }

            if (i == days.length - 1) {
                answer.add(releaseGroupCnt);
            }
        }

        return Arrays.stream(answer.toArray()).flatMapToInt(x -> IntStream.of((int) x)).toArray();
    }

    // Ebook 해설
    public static int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();

        // 각 작업의 배포 가능일 계산
        int n = progresses.length;
        int[] daysLeft = new int[n];
        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0; // 배포될 작업의 수 카운트
        int maxDay = daysLeft[0]; // 현재 배포될 작업 중 가장 늦게 배포될 작업의 가능일

        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxDay) { // 배포 가능일이 가장 늦은 배포일보다 빠를 때
                count++;
            } else {
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }

        answer.add(count); // 마지막으로 카운트된 작업들을 함께 배포
        return answer.stream().mapToInt(x -> x).toArray();
    }

}
