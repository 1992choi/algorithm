package inflearn.lecture01.ex10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex10_04_Answer {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<Brick> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Brick(kb.nextInt(), kb.nextInt(), kb.nextInt()));
        }

        System.out.println(solution(list));
    }

    public static int solution(List<Brick> list) {
        int[] dy = new int[list.size()];
        Collections.sort(list);
        dy[0] = list.get(0).h;

        int answer = dy[0];

        for (int i = 1; i < list.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).w > list.get(i).w && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + list.get(i).h;
            answer = Math.max(dy[i], answer);
        }

        return answer;
    }

    static class Brick implements Comparable<Brick> {
        public int s, h, w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s;
        }
    }

}
