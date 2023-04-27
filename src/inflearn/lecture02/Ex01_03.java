package inflearn.lecture02;

public class Ex01_03 {

    public static void main(String[] args) {
        // CASE 1.
        int[][] arr1 = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(solution(arr1)); // 51

        // CASE 21.
        int[][] arr2 = {
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
        };
        System.out.println(solution(arr2)); // 17
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int[] hyunsu = {0, 0, 12}; // 현수 위치 (x좌표, y좌표, 방향)
        int[] dog = {0, 0, 12}; // 강아지 위치 (x좌표, y좌표, 방향)

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    hyunsu[0] = i;
                    hyunsu[1] = j;
                } else if (board[i][j] == 3) {
                    dog[0] = i;
                    dog[1] = j;
                }
            }
        }

        while (true) {
            answer++;

            move(hyunsu, board);
            if (isSameLocation(hyunsu, dog)) {
                break;
            } else if (answer > 10_000) {
                answer = 0;
                break;
            }

            move(dog, board);
            if (isSameLocation(hyunsu, dog)) {
                break;
            } else if (answer > 10_000) {
                answer = 0;
                break;
            }
        }

        return answer;
    }

    public static void move(int[] target, int[][] board) {
        int direction = target[2]; // 3, 6, 9, 12 : 시계방향
        if (direction == 3) {
            if (target[1] == board[0].length - 1 || board[target[0]][target[1] + 1] == 1) {
                direction = 6;
            } else {
                target[1] = target[1] + 1;
            }
        } else if (direction == 6) {
            if (target[0] == board.length - 1 || board[target[0] + 1][target[1]] == 1) {
                direction = 9;
            } else {
                target[0] = target[0] + 1;
            }
        } else if (direction == 9) {
            if (target[1] == 0 || board[target[0]][target[1] - 1] == 1) {
                direction = 12;
            } else {
                target[1] = target[1] - 1;
            }
        } else {
            if (target[0] == 0 || board[target[0] - 1][target[1]] == 1) {
                direction = 3;
            } else {
                target[0] = target[0] - 1;
            }
        }

        target[2] = direction;
    }

    public static boolean isSameLocation(int[] hyunsu, int[] dog) {
        if (hyunsu[0] == dog[0] && hyunsu[1] == dog[1]) {
            return true;
        }

        return false;
    }
}
