package inflearn.lecture01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex09_01_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Body> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Body(in.nextInt(), in.nextInt()));
        }

        System.out.println(solution(list, n));
    }

    static int solution(List<Body> list, int n) {
        int cnt = 0;
        int max = Integer.MIN_VALUE;

        Collections.sort(list);

        for (Body body : list) {
            if (body.w > max) {
                max = body.w;
                cnt++;
            }
        }

        return cnt;
    }

    static class Body implements Comparable<Body> {
        int h;
        int w;

        Body(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Body o) {
            return o.h - this.h;
        }
    }

}
