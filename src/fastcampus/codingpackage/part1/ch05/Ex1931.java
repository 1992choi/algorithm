package fastcampus.codingpackage.part1.ch05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex1931 {

    public static void main(String[] args) {
        // 강의 먼저 듣고 푼 문제. (백준 사이트 오류로 채점 아직 안해봄)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            times.add(new Time(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(times);

        int maxCount = 0;
        int currentEndTime = 0;
        for (Time time : times) {
            if (time.startTime >= currentEndTime) {
                maxCount++;
                currentEndTime = time.endTime;
            }
        }

        System.out.println(maxCount);
    }

    static class Time implements Comparable<Time> {
        int startTime;
        int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Time o) {
            if (this.endTime == o.endTime) {
                return this.startTime - o.startTime;
            }

            return this.endTime - o.endTime;
        }
    }

}

/*
    풀이

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    Meeting[] meetings = new Meeting[N];
    for (int i = 0; i < N; i++)
        meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());

    Arrays.sort(meetings, (o1, o2) -> {
        if (o1.end == o2.end)
            return o1.start - o2.start;
        return o1.end - o2.end;
    });

    int cnt = 0, ended = 0;
    for (int i = 0; i < N; i++)
        if (ended <= meetings[i].start) {
            cnt++;
            ended = meetings[i].end;
        }
    System.out.println(cnt);
}
 */