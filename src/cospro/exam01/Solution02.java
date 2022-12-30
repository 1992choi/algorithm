package cospro.exam01;

public class Solution02 {

    public int solution(int n) {
        System.out.println("========================== " + n + "*" + n + " Array ==========================");
        int answer = 0;

        int[][] arr = new int[n][n];
        int fillCnt = 1;
        int direction = 1; //0-N, 1-E, 2-S, 3-W
        int x = 0;
        int y = 0;
        boolean isContinue = true;

        do {
            if (direction == 1) {
                if (x >= n || arr[y][x] != 0) {
                    direction = 2;
                    x--;
                    y++;
                } else {
                    arr[y][x++] = fillCnt++;
                }
            } else if (direction == 2) {
                if (y >= n || arr[y][x] != 0) {
                    direction = 3;
                    y--;
                    x--;
                } else {
                    arr[y++][x] = fillCnt++;
                }
            } else if (direction == 3) {
                if (x < 0 || arr[y][x] != 0) {
                    direction = 0;
                    y--;
                    x++;
                } else {
                    arr[y][x--] = fillCnt++;
                }
            } else if (direction == 0) {
                if (y < 0 || arr[y][x] != 0) {
                    direction = 1;
                    x++;
                    y++;
                } else {
                    arr[y--][x] = fillCnt++;
                }
            }

            if (fillCnt - 1 == n * n) {
                isContinue = false;
            }
        } while (isContinue);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    answer += arr[i][j];
                }
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution02 sol = new Solution02();

        System.out.println("sum : " + sol.solution(1));
        System.out.println("sum : " + sol.solution(2));
        System.out.println("sum : " + sol.solution(3));
        System.out.println("sum : " + sol.solution(5));
        System.out.println("sum : " + sol.solution(10));
    }

}
