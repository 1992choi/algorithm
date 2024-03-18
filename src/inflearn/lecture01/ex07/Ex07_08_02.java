package inflearn.lecture01.ex07;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_08_02 {

    public static void main(String[] args) {
        System.out.println(solution(5, 14)); // 3
        System.out.println(solution(8, 3)); // 5
        System.out.println(solution(1, 21)); // 4
    }

    /*  시간 초과로 통과되지 않은 풀이법

    public static int solution(int s, int e) {
        int[] arr = new int[]{-1, 1, 5}; // 점프 방법
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            answer++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll(); // 현재 위치
                for (int j = 0; j < 3; j++) {
                    int move = current + arr[j]; // 점프해서 이동
                    if (move == e) {
                        return answer;
                    }

                    queue.offer(move);
                }
            }
        }

        return answer;
    }
     */

    public static int solution(int s, int e) {
        boolean[] isVisited = new boolean[10001];
        int[] arr = new int[]{-1, 1, 5}; // 점프 방법
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        isVisited[s] = true;
        while (!queue.isEmpty()) {
            answer++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll(); // 현재 위치
                for (int j = 0; j < 3; j++) {
                    int move = current + arr[j]; // 점프해서 이동
                    if (move == e) {
                        return answer;
                    }

                    if (move >=1 && move <= 100001 && !isVisited[move]) {
                        queue.offer(move);
                    }
                    isVisited[move] = true;
                }
            }
        }

        return answer;
    }

}

