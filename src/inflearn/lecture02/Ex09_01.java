package inflearn.lecture02;

public class Ex09_01 {

    public static void main(String[] args) {
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
            for (int j = (int) Math.round(price[i] * 100); j < dy.length; j++) {
                if (dy[j] < dy[j - (int) Math.round(price[i] * 100)] + calorie[i]) {
                    dy[j] = dy[j - (int) Math.round(price[i] * 100)] + calorie[i];
                }
            }
        }

        return dy[(int) Math.round(money * 100)];
    }

}