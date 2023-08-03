package inflearn.lecture01.ex09;

import java.util.*;

public class Ex09_04_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int n = in.nextInt();
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = in.nextInt();
            int time = in.nextInt();
            list.add(new Lecture(money, time));

            if (time > max) {
                max = time;
            }
        }

        System.out.println(solution(list, n, max));
    }

    static int solution(List<Lecture> list, int n, int max) {
        int answer = 0;

        Collections.sort(list);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = max; i > 0; i--) {
            for (; j < n; j++) {
                if (list.get(j).time < i) {
                    break;
                }

                pQ.offer(list.get(j).money);
            }

            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }

        return answer;
    }

    static class Lecture implements Comparable<Lecture> {
        int money;
        int time;

        Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

}
