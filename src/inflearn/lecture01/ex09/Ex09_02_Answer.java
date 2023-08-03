package inflearn.lecture01.ex09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex09_02_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Time(in.nextInt(), in.nextInt()));
        }

        System.out.println(solution(list, n));
    }

    static int solution(List<Time> list, int n) {
        int cnt = 0;

        Collections.sort(list);
        int endTIme = 0;
        for (Time time : list) {
            if (time.s >= endTIme) {
                cnt++;
                endTIme = time.e;
            }
        }

        return cnt;
    }

    static class Time implements Comparable<Time> {
        int s;
        int e;

        Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time o) {
            if (this.e == o.e) {
                return this.s - o.s;
            } else {
                return this.e - o.e;
            }
        }
    }

}
