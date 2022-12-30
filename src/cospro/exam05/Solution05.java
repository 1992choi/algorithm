package cospro.exam05;

public class Solution05 {

    public int solution(int[] enemies, int[] armies) {
        int answer = 0;

        for (int i = 0; i < armies.length; i++) {
            for (int j = 0; j < enemies.length; j++) {
                if (armies[i] >= enemies[j] && enemies[j] != 0) {
                    answer++;
                    enemies[j] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution05 sol = new Solution05();
        int[] enemies1 = {1, 4, 3};
        int[] armies1 = {1, 3};
        int ret1 = sol.solution(enemies1, armies1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] enemies2 = {1, 1, 1};
        int[] armies2 = {1, 2, 3, 4};
        int ret2 = sol.solution(enemies2, armies2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }

}
