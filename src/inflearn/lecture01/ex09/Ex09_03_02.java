package inflearn.lecture01.ex09;

import java.util.*;

public class Ex09_03_02 {

    public static void main(String[] args) {
        /* 그리디 미적용
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Integer[]{in.nextInt(), in.nextInt()});
        }

        System.out.println(solution(list, n));
        */

        // 그리디 적용
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Time(Integer.parseInt(in.next()), 's')); // 시작 시간
            list.add(new Time(Integer.parseInt(in.next()), 'e')); // 종료 시간
        }

        System.out.println(solution2(list, n));
    }

    // 그리디 미적용 - 채점 성공
    public static int solution(List<Integer[]> list, int n) {
        Map<Integer, Integer> time = new HashMap<>(); // key=시간, value=해당 시간에 참석자 수

        // 시간마다 인원수 체크
        for (Integer[] integers : list) {
            for (int i = integers[0]; i < integers[1]; i++) {
                time.put(i, time.getOrDefault(i, 0) + 1);
            }
        }

        // 최대인원 구하기
        return time.values().stream().max(Integer::compareTo).get();
    }

    // 그리디 적용 - 문제해법 보고 푼 문제
    public static int solution2(List<Time> list, int n) {
        int answer = 0;

        Collections.sort(list, (x, y) -> x.time == y.time ? x.status - y.status : x.time - y.time);
        // System.out.println(list);

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).status == 's') {
                count++;
            } else {
                count--;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    static class Time {
        int time;
        char status;

        public Time(int time, char status) {
            this.time = time;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "time=" + time +
                    ", status=" + status +
                    '}';
        }
    }

}
