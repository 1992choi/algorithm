package inflearn.lecture02;

import java.util.Arrays;

public class Ex03_04 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"})); // 3
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"})); // 4
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"})); // 0
    }

    public static int solution(int[] laser, String[] enter) {
        int[] time = new int[1200]; // 영업시간 분다위 배열 - 20:00이 마감이므로 20 * 60 = 1200으로 셋팅

        for (int i = 0; i < enter.length; i++) {
            String enterTime = enter[i].split(" ")[0]; // 방문 시간
            String type = enter[i].split(" ")[1]; // 시술 종류

            int startTime = (Integer.parseInt(enterTime.split(":")[0]) * 60) + (Integer.parseInt(enterTime.split(":")[1])); // 손님 시술 시작시간
            int endTime = startTime + laser[Integer.parseInt(type)];

            for (int j = startTime; j < endTime; j++) {
                time[j] += 1;
            }
        }

        return Arrays.stream(time).max().getAsInt() - 1; // 같은 시간대에 있는 손님 중 한명은 시술을 받는 중이므로 제외
    }

}
