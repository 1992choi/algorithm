package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex09_03_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Time(in.nextInt(), 's'));
            list.add(new Time(in.nextInt(), 'e'));
        }

        System.out.println(solution(list, n));
    }

    static int solution(List<Time> list, int n) {
        int answer = 0;
        int cnt = 0;

        Collections.sort(list);
        for (Time time : list) {
            if (time.state == 'e') {
                cnt--;
            } else {
                cnt++;
            }

            answer = Math.max(cnt, answer);
        }

        return answer;
    }

    static class Time implements Comparable<Time> {
        int time;
        char state;

        Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) {
                return this.state - o.state;
            } else {
                return this.time - o.time;
            }
        }
    }

}
