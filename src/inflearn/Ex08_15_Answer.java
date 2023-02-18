package inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex08_15_Answer {

    static int n;
    static int m;
    static int len;
    static int answer = Integer.MAX_VALUE;
    static int[] combi;
    static List<Point> hs;
    static List<Point> pz;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = in.nextInt();
                if (tmp == 1) {
                    hs.add(new Point(i, j));
                } else if (tmp == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }
        len = pz.size();
        combi = new int[m];

        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int level, int s) {
        if (level == m) {
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
