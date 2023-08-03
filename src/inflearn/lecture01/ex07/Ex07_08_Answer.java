package inflearn.lecture01.ex07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex07_08_Answer {

    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> queue = new LinkedList<>();

    public static int bfs(int s, int e) {
        ch = new int[10_001];
        ch[s] = 1;
        queue.offer(s);

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx == e) {
                        return level + 1;
                    }
                    if (nx >= 1 && nx <= 10_000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();

        System.out.println(bfs(s, e));
    }

}

