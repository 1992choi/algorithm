package inflearn.lecture02;

public class Ex09_01 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(2, 8.00, new String[]{"700 7.00", "199 2.00"})); // 796
        System.out.println(solution(3, 8.00, new String[]{"700 7.00", "299 3.00", "499 5.00"})); // 798
    }

    public static int solution(int candyNum, double money, String[] candyInfo) {
        // i원을 가지고 얻을 수 있는 최대 칼로리를 담을 배열 선언
        int[] dy = new int[(int) Math.round(money * 100) + 1];

        // 사탕정보 초기화
        int[] calorie = new int[candyNum];
        double[] price = new double[candyNum];
        for (int i = 0; i < candyNum; i++) {
            calorie[i] = Integer.parseInt(candyInfo[i].split(" ")[0]);
            price[i] = Double.parseDouble(candyInfo[i].split(" ")[1]);
        }

        // DP 시작
        for (int i = 0; i < candyNum; i++) {
            /*
                - i원을 가지고 있을 때 캔디의 칼로리 최대 구하기
                    1번 예제의 입력값중 캔디정보가 각 각 아래와 같다고 가정하면
                    : 700칼로리 - 7.00원 (간편한 계산을 위해 700원으로 간주)
                    : 199칼로리 - 2.00원 (간편한 계산을 위해 200원으로 간주)

                    700번째 배열부터 dy배열의 끝까지 탐색하며, 아래의 계산을 반복
                        1. dy[700 - 700] + 칼로리 계산 (* 700 - 700이 도출된 이유는 사탕정보 배열에서 첫번째 요소인 700원을 기준으로 계산을 시작하기 위함이다.)
                        2. (1)의 계산결과가 현재의 값보다 크다면 값 갱신
                        3. j를 증가시켜 dy[701 - 700] + 칼로리 계산
                        4. (3)의 계산결과가 현재의 값보다 크다면 값 갱신
                        5. 반복...
             */
            for (int j = (int) Math.round(price[i] * 100); j < dy.length; j++) {
                if (dy[j] < dy[j - (int) Math.round(price[i] * 100)] + calorie[i]) {
                    dy[j] = dy[j - (int) Math.round(price[i] * 100)] + calorie[i];
                }
            }
        }

        return dy[(int) Math.round(money * 100)];
    }

}