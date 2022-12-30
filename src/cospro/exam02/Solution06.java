package cospro.exam02;

import java.util.Arrays;

public class Solution06 {

    public int[] solution(String commands) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'U') {
                y++;
            } else if (commands.charAt(i) == 'R') {
                x++;
            } else if (commands.charAt(i) == 'D') {
                y--;
            } else if (commands.charAt(i) == 'L') {
                x--;
            }
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution06 sol = new Solution06();
        String commands = "URDDL";
        int[] ret = sol.solution(commands);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }

}
