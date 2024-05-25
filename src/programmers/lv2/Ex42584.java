package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 Lv2. 주식가격 - https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class Ex42584 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3}))); // [4, 3, 1, 1, 0]
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int second = 1;
            for (int j = i + 1; j < prices.length - 1; j++) {
                if (prices[i] <= prices[j]) { // 가격이 떨어지지 않았을 때, 초를 늘림
                    second++;
                } else { // 가격이 떨어진 경우, 이후 가격을 생각하지 않으므로 판별 중단
                    break;
                }
            }
            answer[i] = second;
        }

        return answer;
    }

}

