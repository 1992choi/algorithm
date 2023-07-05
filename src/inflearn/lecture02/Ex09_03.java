package inflearn.lecture02;

public class Ex09_03 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(new int[]{10, 20, 15, 25, 10, 20})); // 75
    }

    public static int solution(int[] stairs) {
        // i번째 계단에서 얻을 수 있는 최대 점수
        int[] dy = new int[stairs.length + 1];

        // DP
        dy[1] = stairs[0]; // 1번째 계단은 경우에 수가 1개 밖에 없으니 1번째 계단에서 얻을 수 있는 점수를 그대로 사용
        dy[2] = stairs[0] + stairs[1]; // 2번째 계단은 경웨 수가 2개이나 1번 계단을 거쳐 2번으로 오는 것이 높은 점수를 얻을 수 있으므로 1번과 2번 계단의 합으로 값을 할당 (* 얻을 수 있는 점수는 모두 양수이므로)
        for (int i = 2; i < stairs.length; i++) {
            dy[i + 1] = Math.max(dy[i - 1] + stairs[i], dy[i - 2] + stairs[i - 1] + stairs[i]);
        }

        return dy[stairs.length];
    }

}