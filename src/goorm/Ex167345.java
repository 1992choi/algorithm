package goorm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 단풍나무
public class Ex167345 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 풀이
        int answer = 0;
        while(true) {
            // 모든 구역이 물들었는지 판단
            if (done(arr)) {
                break;
            }

            answer++;
            Queue<Integer[]> coordinateQueue = new LinkedList<>();

            // 물든 구역 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 위
                    if (i > 0) {
                        if (arr[i - 1][j] == 0 && arr[i][j] >= 0) {
                            coordinateQueue.add(new Integer[]{i, j});
                        }
                    }

                    // 오른쪽
                    if (j < n - 1) {
                        if (arr[i][j + 1] == 0 && arr[i][j] >= 0) {
                            coordinateQueue.add(new Integer[]{i, j});
                        }
                    }

                    // 아래
                    if (i < n - 1) {
                        if (arr[i + 1][j] == 0 && arr[i][j] >= 0) {
                            coordinateQueue.add(new Integer[]{i, j});
                        }
                    }

                    // 왼쪽
                    if (j > 0) {
                        if (arr[i][j - 1] == 0 && arr[i][j] >= 0) {
                            coordinateQueue.add(new Integer[]{i, j});
                        }
                    }
                }
            }

            // 물들음 처리
            while (!coordinateQueue.isEmpty()) {
                Integer[] coordinate = coordinateQueue.poll();
                if (arr[coordinate[0]][coordinate[1]] > 0) {
                    arr[coordinate[0]][coordinate[1]]--;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean done(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
