package inflearn.lecture02.ex03;

import java.util.LinkedList;
import java.util.Queue;

public class Ex03_04_Answer {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"})); // 3
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"})); // 4
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"})); // 0

        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2", "11:11 2", "11:12 2", "11:13 2"})); // 5
    }

    public static int solution(int[] laser, String[] enter) {
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(inList[0][1]);
        int fT = inList[0][0];
        int pos = 1;
        for (int t = fT; t <= 1200; t++) {
            if (pos < n && t == inList[pos][0]) {
                if (Q.isEmpty() && inList[pos][0] > fT) fT = inList[pos][0];
                Q.offer(inList[pos][1]);
                pos++;
            }
            if (t == fT && !Q.isEmpty()) {
                int idx = Q.poll();
                fT += laser[idx];
            }
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }

}
