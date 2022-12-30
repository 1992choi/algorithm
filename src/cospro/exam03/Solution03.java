package cospro.exam03;

public class Solution03 {

    public int solution(String[] bishops) {
        int answer = 0;
        int[][] chessBoard = new int[8][8];

        for (int i = 0; i < bishops.length; i++) {
            String tmp = bishops[i];
            int x = 0;
            int y = 0;

            // 북서 방향
            x = tmp.charAt(0) - 65;
            y = Integer.parseInt(String.valueOf(tmp.charAt(1))) - 1;
            while (x >= 0 && y <= 7) {
                chessBoard[x][y] = 1;
                x--;
                y++;
            }

            // 북동 방향
            x = tmp.charAt(0) - 65;
            y = Integer.parseInt(String.valueOf(tmp.charAt(1))) - 1;
            while (x <= 7 && y <= 7) {
                chessBoard[x][y] = 1;
                x++;
                y++;
            }

            // 남동 방향
            x = tmp.charAt(0) - 65;
            y = Integer.parseInt(String.valueOf(tmp.charAt(1))) - 1;
            while (x <= 7 && y >= 0) {
                chessBoard[x][y] = 1;
                x++;
                y--;
            }

            // 남서 방향
            x = tmp.charAt(0) - 65;
            y = Integer.parseInt(String.valueOf(tmp.charAt(1))) - 1;
            while (x >= 0 && y >= 0) {
                chessBoard[x][y] = 1;
                x--;
                y--;
            }
        }

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        String[] bishops1 = {new String("D5")};
        int ret1 = sol.solution(bishops1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        String[] bishops2 = {new String("D5"), new String("E8"), new String("G2")};
        int ret2 = sol.solution(bishops2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }

}
