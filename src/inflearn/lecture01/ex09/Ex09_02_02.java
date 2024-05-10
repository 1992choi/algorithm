package inflearn.lecture01.ex09;

import java.util.*;

public class Ex09_02_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Integer[]{in.nextInt(), in.nextInt()});
        }

        // System.out.println(solution(list, n));
        System.out.println(solution2(list, n));
    }

    // 일부 통과 + 오답 + 타임아웃
    public static int solution(List<Integer[]> list, int n) {
        int answer = 0;
        boolean[] room = new boolean[10_000_000];

        // 회의 시간이 짧고 시작 시간이 빠른 것부터 정렬
        Collections.sort(list, (x, y) -> x[1] - x[0] == y[1] - y[0] ? x[0] - y[0] : (x[1] - x[0]) - (y[1] - y[0]));

        // 정렬확인
//        for (Integer[] integers : list) {
//            System.out.println(Arrays.toString(integers));
//        }

        // 조건 탐색
        for (Integer[] integers : list) {
            // 회의실 사용할 수 있는지 확인
            boolean available = true;

            for (int i = integers[0]; i < integers[1]; i++) {
                if (room[i]) {
                    available = false;
                    break;
                }
            }

            // 사용할 수 있다면 예약
            if (available) {
                for (int i = integers[0]; i < integers[1]; i++) {
                    room[i] = true;
                }
                answer++;
            }
        }

        return answer;
    }

    // 문제해법 보고 푼 문제.
    public static int solution2(List<Integer[]> list, int n) {
        int answer = 0;

        // 회의가 빨리 끝나는 순으로 정렬 (만약 종료 시간이 같다면 시작 시간이 빠른 것부터 정렬)
        list.sort((x, y) -> Objects.equals(x[1], y[1]) ? x[0] - y[0] : x[1] - y[1]);

        // 정렬확인
//        for (Integer[] integers : list) {
//            System.out.println(Arrays.toString(integers));
//        }

        int endTime = 0; // 직전 회의 종료 시간
        for (Integer[] i : list) {
            if (i[0] >= endTime) { // 회의 시작 시간이 직전 회의 종료 시간보다 이후이면 배정
                endTime = i[1];
                answer++;
            }
        }

        return answer;
    }

}
