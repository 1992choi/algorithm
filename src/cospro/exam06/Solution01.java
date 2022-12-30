package cospro.exam06;

public class Solution01 {

    public int solution(int n, int[][] garden) {
        int answer = 0;
        boolean isContinue = false;

        do {
            isContinue = false;

            // 핀 꽃 확인
            for (int i = 0; i < garden.length; i++) {
                for (int j = 0; j < garden[i].length; j++) {
                    if (garden[i][j] == 0) {
                        isContinue = true;
                    }
                }
            }

            if (isContinue) {
                answer++;

                // 꽃 피우기
                for (int i = 0; i < garden.length; i++) {
                    for (int j = 0; j < garden[i].length; j++) {
                        if (garden[i][j] == 1) {
                            if (i > 0) {
                                garden[i - 1][j] = 1;
                            }
                            if (i < garden.length - 1) {
                                garden[i + 1][j] = 1;
                            }
                            if (j > 0) {
                                garden[i][j - 1] = 1;
                            }
                            if (j < garden.length - 1) {
                                garden[i][j + 1] = 1;
                            }
                        }
                    }
                }
            }
        } while (isContinue);

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        int n1 = 3;
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(n1, garden1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(n2, garden2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

    }

}
