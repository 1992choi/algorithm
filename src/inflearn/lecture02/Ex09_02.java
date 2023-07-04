package inflearn.lecture02;

public class Ex09_02 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(7, new int[][]{{4, 5}, {3, 6}, {2, 7}, {1, 4}, {6, 7}, {1, 5}})); // 5
    }

    public static int solution(int sum, int[][] pipe) {
        // i 길이의 수도관을 만들었을 때, 최대용량을 기록할 배열 선언
        int[] dy = new int[sum + 1];

        // DP
        for (int i = 0; i < pipe.length; i++) {
            int length = pipe[i][0];
            int capacity = pipe[i][1];

            // 중복처리를 피하기 위해서 배열의 끝부분부터 앞부분으로 진행
            for (int j = dy.length - 1; j >= length; j--) {
                /*
                    계산된 파이브배열이 아직 구축되지 않았다면, 완성할 수 없으므로 skip
                    Ex) dy = 0, 0, 0, 0, 0, 0, 0, 0 이며
                        length = 4 (=pipe의 첫번째 인덱스 진행 중이라 가정)
                        j = 7이면
                        dy[7 - 4]의 값은 아직 0이므로 계산하지 않고 넘어감. 길이 3일 때 파이프가 없으므로, 4를 추가해도 길이 7을 만들 수 없기 때문

                    단, length와 j가 같다면 해당 길이는 파이프를 만들 수 있는 케이스이므로 로직이 진행되어야함
                 */
                if (dy[j - length] == 0 && length != j) {
                    continue;
                }

                // 값이 0일때는 자신의 용량인 capacity를 할당하고 그렇지 않은 경우에는 이전 파이프의 용량과 내 용량 중 적은 값을 할당한다.
                // dy[j] = dy[j - length] == 0 ? capacity : Math.min(dy[j - length], capacity); // 정답은 맞았지만 dy 값의 변화가 해답과 달라 확인해보니 잘못된 로직이어서 아래처럼 수정
                dy[j] = length == j ? Math.max(dy[length], capacity) : Math.max(dy[j], Math.min(dy[j - length], capacity));
            }
        }

        return dy[sum];
    }

}