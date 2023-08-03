package inflearn.lecture02.ex04;

import java.util.Arrays;

public class Ex04_06_Answer {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, 5)); // 3
        System.out.println(solution(new int[]{8, 5, 2, 9, 10, 7}, 30)); // 6
        System.out.println(solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100)); // 5
    }

    public static int solution(int[] tasks, long k) {
        int[] sT = new int[tasks.length + 1];
        System.arraycopy(tasks, 0, sT, 1, tasks.length);
        Arrays.sort(sT);
        int rest = tasks.length;
        for (int i = 1; i < sT.length; i++) {
            long time = ((long) rest * (sT[i] - sT[i - 1]));
            if (k < time) {
                long idx = k % rest;
                int cnt = 0;
                for (int j = 0; j < tasks.length; j++) {
                    if (tasks[j] >= sT[i]) {
                        if (cnt == idx) return j + 1;
                        cnt++;
                    }
                }
            } else {
                k -= time;
                rest--;
            }
        }
        return -1;
    }

}