package inflearn.lecture01.ex09;

import java.util.*;

public class Ex09_04_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Lecture> lectures = new ArrayList<>();
        int maxDay = 0; // 최대로 강의할 수 있는 일수
        for (int i = 0; i < n; i++) {
            lectures.add(new Lecture(in.nextInt(), in.nextInt()));
            maxDay = Math.max(maxDay, lectures.get(i).day);
        }

        System.out.println(solution(lectures, n, maxDay));
    }

    public static int solution(List<Lecture> lectures, int n, int maxDay) {
        int answer = 0;

        // 날짜 기준 내림차순으로 정렬
        Collections.sort(lectures, (x, y) -> y.day - x.day);
        // System.out.println(lectures);

        // 수입 판단
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int lastIndex = 0; // 마지막으로 큐에 넣은 리스트의 인덱스
        // 최대 일수부터 -1씩 차감하며
        for (int i = maxDay; i > 0; i--) {
            // 강의와 비교하여
            for (int j = lastIndex; j < n; j++) {
                // 현재 기준 일수(=maxDay)와 같은 강의날짜 담기
                if (lectures.get(j).day == i) {
                    queue.offer(lectures.get(j).fee);
                    lastIndex = j;
                }
            }

            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }


        return answer;
    }

    static class Lecture {
        int fee;
        int day;

        public Lecture(int fee, int day) {
            this.fee = fee;
            this.day = day;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "fee=" + fee +
                    ", day=" + day +
                    '}';
        }
    }

}