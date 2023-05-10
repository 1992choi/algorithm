package inflearn.lecture02;

import java.util.Arrays;

public class Ex01_08_Answer {

    public static void main(String[] args) {
        // CASE 1.
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}))); // [3, 1, 2, 2]

        // CASE 2.
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5}))); // [3, 1, 2, 1, 3]

        // CASE 3.
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7}))); // [6, 2, 2, 4, 2, 3, 4, 1]

        // CASE 4.
        System.out.println(Arrays.toString(solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4}))); // [6, 5, 6, 6, 5, 4, 6]

        // CASE 5.
        System.out.println(Arrays.toString(solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3}))); // [2, 2, 0, 2]
    }

    public static int[] solution(int[] enter, int[] exit) {
        int n = enter.length;
        for (int i = 0; i < n; i++) {
            enter[i]--;
            exit[i]--;
        }

        int[] enterIdx = new int[n];
        for (int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i;
        }

        int[] enterT = new int[n];
        int[] exitT = new int[n];
        int cnt = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && j <= enterIdx[exit[i]]) {
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!(exitT[i] < enterT[j] || exitT[j] < enterT[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }

}
