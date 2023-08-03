package inflearn.lecture02.ex01;

import java.util.*;

public class Ex01_07 {

    public static void main(String[] args) {
        // CASE 1.
        System.out.println(solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218")); // 8

        // CASE 2.
        System.out.println(solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592")); // 12

        // CASE 3.
        System.out.println(solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677")); // 13

        // CASE 4.
        System.out.println(solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122")); // 8
    }

    public static int solution(int[] keypad, String password) {
        int answer = 0;
        int[][] tmpKeypad = new int[3][3];

        // 키패드 2차원 배열로 변환
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmpKeypad[i][j] = keypad[idx++];
            }
        }

        // 인접 패드 탐색
        Map<Integer, List<Integer>> group = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                List<Integer> list = new ArrayList<>();
                int currentPad = tmpKeypad[i][j];

                if (i > 0) { // 12시 방향
                    list.add(tmpKeypad[i - 1][j]);
                }
                if (i > 0 && j < 2) { // 1시 방향
                    list.add(tmpKeypad[i - 1][j + 1]);
                }
                if (j < 2) { // 3시 방향
                    list.add(tmpKeypad[i][j + 1]);
                }
                if (i < 2 && j < 2) { // 5시 방향
                    list.add(tmpKeypad[i + 1][j + 1]);
                }
                if (i < 2) { // 6시 방향
                    list.add(tmpKeypad[i + 1][j]);
                }
                if (i < 2 && j > 0) { // 7시 방향
                    list.add(tmpKeypad[i + 1][j - 1]);
                }
                if (j > 0) { // 9시 방향
                    list.add(tmpKeypad[i][j - 1]);
                }
                if (i > 0 && j > 0) { // 11시 방향
                    list.add(tmpKeypad[i - 1][j - 1]);
                }

                group.put(currentPad, list);
            }
        }

        for (int i = 1; i < password.length(); i++) {
            int prev = password.charAt(i - 1) - 48;
            int current = password.charAt(i) - 48;

            List currentPadList = group.get(current); // 현재 비밀번호와 인접한 패드 리스트

            /*
                1. 이전에 누른 비밀번호와 현재 누른 비밀번호가 동일한 숫자면 0초
                2. 이전에 누른 비밀번호와 현재 누른 비밀번호가 인접해있으면 1초
                3. 그렇지 않은 경우는 2초 (1번과 2번에 해당하지 않으면 모두 3번의 케이스에 해당하므로 무조건 2초를 더해도 무방하다.)
             */
            answer += prev == current ? 0 : currentPadList.contains(prev) ? 1 : 2;
        }

        return answer;
    }

}
